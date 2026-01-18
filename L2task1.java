import java.util.Scanner;

public class L2task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password to check strength: ");
        String password = sc.nextLine();
        
        int score = 0;
        
        // Criteria
        boolean hasLength = password.length() >= 8;
        boolean hasUpper = !password.equals(password.toLowerCase());
        boolean hasLower = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()-+].*");
        
        if (hasLength) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;
        
        System.out.println("Strength Analysis:");
        System.out.println("- Length >= 8: " + (hasLength ? "Yes" : "No"));
        System.out.println("- Uppercase: " + (hasUpper ? "Yes" : "No"));
        System.out.println("- Lowercase: " + (hasLower ? "Yes" : "No"));
        System.out.println("- Numbers: " + (hasDigit ? "Yes" : "No"));
        System.out.println("- Special Char: " + (hasSpecial ? "Yes" : "No"));
        
        System.out.print("Result: ");
        switch (score) {
            case 5:
                System.out.println("Very Strong");
                break;
            case 4:
                System.out.println("Strong");
                break;
            case 3:
                System.out.println("Medium");
                break;
            case 2:
                System.out.println("Weak");
                break;
            default:
                System.out.println("Very Weak");
        }
        
        sc.close();
    }
}
