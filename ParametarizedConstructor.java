import java.lang.*;
import java.util.Scanner;
public class ParametarizedConstructor{
    int a, b, c, d;
    int res;
    {Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of a:"+a);
        int a = sc.nextInt();
        System.out.println("enter the value of b:"+b);
        int b = sc.nextInt();
        
    }

    ParametarizedConstructor(int p, int q){
        a= p;
        b=q;
        res = a+b;
        System.out.println("the sum of two numbers:"+res);
    }

    // ParametarizedConstructor(){
    //     Scanner sc = new Scanner(System.in);
    //     a = sc.nextInt();
    //     System.out.println("enter the value of a:"+a);
    //     b = sc.nextInt();
    //     System.out.println("enter the value of b:"+b);
    //     c = sc.nextInt();
    //     System.out.println("enter the value of c:"+c);

    //     res = a+b+c;
    //     System.out.println("the sum of three numbers:"+res);
    // }

    // ParametarizedConstructor(){
    //     Scanner sc = new Scanner(System.in);
    //     a = sc.nextInt();
    //     System.out.println("enter the value of a:"+a);
    //     b = sc.nextInt();
    //     System.out.println("enter the value of b:"+b);
    //     c = sc.nextInt();
    //     System.out.println("enter the value of c:"+c);
    //     d = sc.nextInt();
    //     System.out.println("enter the value of d:"+d);

    //     res = a+b+c+d;
    //     System.out.println("the sum of four numbers:"+res);
    // }

    public static void main(String[] args){
        ParametarizedConstructor pc1 = new ParametarizedConstructor(int a, int b);
      
        // ParametarizedConstructor pc2 = new ParametarizedConstructor();
       
        // ParametarizedConstructor pc3 = new ParametarizedConstructor();
      
    }
}