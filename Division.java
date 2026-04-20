import java.util.Scanner;
public class Division{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first number:");
        double num1 = sc.nextDouble();
        System.out.println("enter the second number:");
        double num2 = sc.nextDouble();

        try{
            double result = num1/num2;
            if(result < 0.01){
                throw new Exception ("Result is less than 0.01");
            }
            System.out.println("The result of division is:"+result);
        }catch (ArithmeticException e){
            System.out.println("Error: cannot divide by zero.");
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        sc.close();
    }
}