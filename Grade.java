import java.lang.*;
import java.util.Scanner;

public class Grade{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your grade: ");
        int i = sc.nextInt();

        if(i>=90){
            System.out.println("Grade: A");
        }
        else if(i>=80){
            System.out.println("Grade: B");
        }
        else if(i>=70){
            System.out.println("Grade: C");
        }
        else if(i>=60){
            System.out.println("Grade: D");
        }
        else if(i>=50){
            System.out.println("Grade: E");
        }
        else{
            System.out.println("Grade: F(Fail)");
        }
    }
}