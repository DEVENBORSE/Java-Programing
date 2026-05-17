import java.util.Scanner;
import java.util.ArrayList;

public class InbuiltPackageExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.println("Enter 3 names:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            String name = scanner.nextLine();
            names.add(name);
        }

        System.out.println("\nNames Entered:");
        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }
}
