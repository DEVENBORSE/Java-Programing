import java.util.Scanner;
import java.lang.*;

public class ParameterizedConstructor {
    int a, b, c, d;
    int res;

    // Instance Block (Fixing Variable Assignment)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        a = sc.nextInt();
        System.out.print("Enter the value of b: ");
        b = sc.nextInt();
    }

    // Constructor with Two Parameters
    ParameterizedConstructor(int p, int q) {
        a = p;
        b = q;
        res = a + b;
        System.out.println("The sum of two numbers: " + res);
    }

    // Constructor with Three Parameters
    ParameterizedConstructor(int p, int q, int r) {
        a = p;
        b = q;
        c = r;
        res = a + b + c;
        System.out.println("The sum of three numbers: " + res);
    }

    // Constructor with Four Parameters
    ParameterizedConstructor(int p, int q, int r, int s) {
        a = p;
        b = q;
        c = r;
        d = s;
        res = a + b + c + d;
        System.out.println("The sum of four numbers: " + res);
    }

    public static void main(String[] args) {
        // Correct Constructor Call
        ParametarizedConstructor pc1 = new ParameterizedConstructor(5, 10);

        // Additional constructor calls to test other cases
        ParametarizedConstructor pc2 = new ParameterizedConstructor(3, 7, 2);
        ParametarizedConstructor pc3 = new ParameterizedConstructor(1, 4, 6, 8);
    }
}
