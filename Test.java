import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int a = scan.nextInt();
        scan.nextLine(); // Consume the leftover newline character
        
        String s = scan.nextLine(); // Now read the full line
        double d = scan.nextDouble();
        
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + a);

        System.out.println("================================");

        
        for (int i = 0; i < 3; i++) {
            String g = scan.next(); 
            int n = scan.nextInt(); 
            
         
            System.out.printf("%-15s%03d%n", g, n);
        }

        System.out.println("================================");


    }
}
        

    
