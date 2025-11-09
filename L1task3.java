import java.util.Scanner;
public class L1task3 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        int[] marks = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            System.out.print("Enter marks for subject " + (i+1) + ": ");
            marks[i] = sc.nextInt();
            sum += marks[i];
        }
        double average = (double) sum / n;
        char grade;
        if(average >= 90){
            grade = 'A';
        } else if(average >= 80){
            grade = 'B';
        } else if(average >= 70){
            grade = 'C';
        } else if(average >= 60){
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Average marks: " + average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
    
}
