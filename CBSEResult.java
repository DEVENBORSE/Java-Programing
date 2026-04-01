import java.lang.*;
import java.util.Scanner;

public class CBSEResult{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the marks of physics:");
        int physics = sc.nextInt();
        System.out.println("enter the marks of chemistry:");
        int chemistry = sc.nextInt();
        System.out.println("enter the marks of biology:");
        int biology = sc.nextInt();
        System.out.println("enter the marks of math:");
        int math = sc.nextInt();
        System.out.println("enter the marks of english:");
        int english = sc.nextInt();

        float percentage = ((physics+chemistry+biology+math+english)/500.0f)*100;
        System.out.println("your percentage is "+percentage+"%");

    }
}