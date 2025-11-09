import java.util.Random;
import java.util.Scanner;
public class L1task4 {
    public static void main(String[]args){
        Scanner sc = new Scanner (System.in);
        String lower="abcdefghijklmnopqrstuvwxyz";
        String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits="0123456789";
        String special="!@#$%^&*()-+";
        System.out.print("Enter passwword length: ");
        int length=sc.nextInt();
        sc.nextLine();
        System.out.print("Include number? (y/n): ");
        boolean includeDigits=sc.nextLine().equalsIgnoreCase("y");
        System.out.print("Include uppercase? (y/n): ");
        boolean includeUpper=sc.nextLine().equalsIgnoreCase("y");
        System.out.print("Include lowercase? (y/n): ");
        boolean includeLower=sc.nextLine().equalsIgnoreCase("y");
        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial=sc.nextLine().equalsIgnoreCase("y"); 
        String allChars="";
        if(includeDigits){
            allChars+=digits;
        if(includeUpper){
            allChars+=upper;
        }    
        if(includeLower){
            allChars+=lower;
        }
        if(includeSpecial){
            allChars+=special;
        }
        if(allChars.isEmpty()){
            System.out.println("No character types selected. Cannot generate password.");
        return;
        }
        Random rand=new Random();
        StringBuilder password=new StringBuilder();
        for(int i=0; i<length; i++){
            int index=rand.nextInt(allChars.length());
            password.append(allChars.charAt(index));
        }
        System.out.println("Generated Password: " + password.toString());
        sc.close();
    }
    }
    
}
