import java.util.Scanner;
public class MathClass {
    public static void main(String[] args) {
        double result;

        System.out.println("The value of PI is: " + Math.PI);

        result = Math.sqrt(9);
        System.out.println("Square root of 9 is: " + result);

        result = Math.pow(2, 3);
        System.out.println("2 raised to the power of 3 is: " + result);

        result = Math.abs(-5);
        System.out.println("Absolute value of -5 is: " + result);

        result = Math.random();
        System.out.println("Random number: " + result);

        result = Math.max(10, 20);
        System.out.println("Maximum of 10 and 20 is: " + result);

        result = Math.min(10, 20);
        System.out.println("Minimum of 10 and 20 is: " + result);

        result = Math.round(3.14);
        System.out.println("Rounded value of 3.14 is: " + result);

        result = Math.ceil(3.14);
        System.out.println("Ceiling value of 3.14 is: " + result);

        result = Math.floor(3.99);
        System.out.println("Floor value of 3.14 is: " + result);


        double a;
        double b;
        double c;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of a: ");
        a = sc.nextDouble();

        System.out.println("Enter the value of b: ");
        b = sc.nextDouble();

        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("The value of c is: " + c + "cm");


        double radius;
        double circumference;
        double area;
        double volume;

        System.out.print("Enter the radius: ");
        radius = sc.nextDouble();

        circumference = 2 * Math.PI * radius;
        area = Math.PI * Math.pow(radius, 2);
        volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);

        System.out.printf("The circumference is: %.1fcm\n" , circumference );
        System.out.printf("The area is : %.1fcm²\n", area );
        System.out.printf("The volume is : %.1fcm³\n" ,volume );
    }
}

