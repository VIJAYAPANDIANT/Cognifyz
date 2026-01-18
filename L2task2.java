import java.util.Scanner;
import java.io.*;

public class L2task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. Encrypt File");
        System.out.println("2. Decrypt File");
        System.out.print("Choose option (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        
        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();
        
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }
        
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        
        String result = "";
        int shift = 3; // Simple Caesar Cipher with shift 3
        
        if (choice == 1) {
            result = process(content.toString(), shift);
            System.out.println("Encryption completed.");
        } else if (choice == 2) {
            result = process(content.toString(), -shift);
            System.out.println("Decryption completed.");
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        
        System.out.print("Enter output file path: ");
        String outPath = sc.nextLine();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {
            bw.write(result);
            System.out.println("Result saved to " + outPath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        
        sc.close();
    }
    
    private static String process(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
             if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift + 26) % 26 + base);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
