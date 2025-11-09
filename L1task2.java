
import java.util.Scanner;

public class L1task2 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String input = sc.nextLine();
        String clean=input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();
        if(clean.equals(reversed)){
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }
        sc.close();

    }
    
    
}
