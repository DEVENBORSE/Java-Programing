class MathOperations {
    // Overloaded method with two int parameters
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method with three int parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method with double parameters
    double add(double a, double b) {
        return a + b;
    }
}

public class MethodOverloadingExample {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        System.out.println("Addition of two integers: " + math.add(5, 10));
        System.out.println("Addition of three integers: " + math.add(5, 10, 15));
        System.out.println("Addition of two doubles: " + math.add(5.5, 2.5));
    }
}
