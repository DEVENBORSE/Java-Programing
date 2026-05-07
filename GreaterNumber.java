import java.lang.*;
import java.util.Scanner;

public class GreaterNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of 'a': ");
        int a = sc.nextInt();
        System.out.println("Enter the value of 'b': ");
        int b = sc.nextInt();
        System.out.println("Enter the value of 'c': ");
        int c = sc.nextInt();

        if(a>b && a>c){
            System.out.println("The value of 'a' : "+a+" is greater than 'b' and 'c'");
        }
        else if(b>a && b>c){
            System.out.println("The value of 'b' : "+b+" is greater than 'a' and 'c'");
        }
        else if(c>a && c>b){
            System.out.println("The value of 'c': "+c+" is greater than 'a' and 'b'");
        }
    }
}