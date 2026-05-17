import java.util.Scanner;
public class CompundInterestCalculator{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double principal, rate, compoundInterest;
        int timeCompounded, years;

        System.out.print("Enter principal amount: ");
        principal = sc.nextDouble();

        System.out.print("Enter rate of interest: ");
        rate = sc.nextDouble() / 100;

        System.out.print("Enter time compounded per year: ");
        timeCompounded= sc.nextInt();

        System.out.print("Enter number of years: ");
        years = sc.nextInt();

        compoundInterest = principal * Math.pow(1 + rate / timeCompounded, timeCompounded * years) ;

        System.out.printf("Compound Interest after %d years is $%.2f\n", years, compoundInterest);
    }
}