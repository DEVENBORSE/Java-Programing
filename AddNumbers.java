import java.lang.*;
import java.util.Scanner;

public class AddNumbers{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the first number:");
        int a = sc.nextInt();
        System.out.println("enter the second number:");
        int b = sc.nextInt();
        System.out.println("enter the third number:");
        int c = sc.nextInt();
        int sum = a + b + c ;
        System.out.println("sum of three numbers is: "+sum);

    }
}
//for importing the full string:
// String str= sc.nextLine();
// System.out.println(str);