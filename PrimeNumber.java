public class PrimeNumber {
    public static void main(String[] args) {
        for (int i = 50; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && i > 1) {
                System.out.println(i);
            }
        }
    }
}