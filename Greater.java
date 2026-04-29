import java.util.Scanner;
public class Greater {
    public static void main(String[] args) {
        Scanner var = new Scanner(System.in);
        System.out.println("enter the first number:");
        int a= var.nextInt();
        System.out.println("enter the second number:");
        int b= var.nextInt();
        System.out.println("enter the third number:");
        int c= var.nextInt();
        if (a>b && a>c){
            System.out.println("a= "+a+" is greater");
        }
        else if(b>a && b>c){
            System.out.println("b= "+b+" is greater");
        }
        else{
            System.out.println("c= "+c+" is greater");
        }

    }
}