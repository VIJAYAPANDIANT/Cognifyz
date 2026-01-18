import java.io.*;
import java.net.*;
import java.util.Scanner;

public class L2task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Mode:");
        System.out.println("1. Server");
        System.out.println("2. Client");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        try {
            if (choice == 1) {
                runServer(sc);
            } else if (choice == 2) {
                runClient(sc);
            } else {
                System.out.println("Invalid mode.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }

    private static void runServer(Scanner sc) throws IOException {
        int port = 5000;
        System.out.println("Starting Server on port " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Waiting for client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            handleChat(socket, sc, "Server");
        }
    }

    private static void runClient(Scanner sc) throws IOException {
        String host = "localhost";
        int port = 5000;
        System.out.println("Connecting to Server at " + host + ":" + port + "...");
        Socket socket = new Socket(host, port);
        System.out.println("Connected to Server!");

        handleChat(socket, sc, "Client");
    }

    // Shared chat logic
    private static void handleChat(Socket socket, Scanner consoleInput, String userType) throws IOException {
        // Output stream to send messages
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Input stream to read messages (run in separate thread)
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Thread readerThread = new Thread(() -> {
            try {
                String incoming;
                while ((incoming = in.readLine()) != null) {
                    System.out.println("\n[" + (userType.equals("Server") ? "Client" : "Server") + "]: " + incoming);
                    System.out.print("You: ");
                }
            } catch (IOException e) {
                System.out.println("Connection closed.");
            }
        });
        readerThread.start();

        System.out.println("Start chatting! Type 'exit' to quit.");
        System.out.print("You: ");
        while (true) {
            String message = consoleInput.nextLine();
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
            out.println(message);
            System.out.print("You: ");
        }
        socket.close();
    }
}
