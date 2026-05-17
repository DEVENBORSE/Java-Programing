import java.lang.*;
import java.util.Scanner;

public class Tax{
    public static void main(String[] args){
        float tax = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the income: ");
        float income = sc.nextFloat();
        if(income <= 25000){
            tax = (float) (income * 0.1);
        }
        else if(income>25000 && income <= 50000){
            tax = (float) (income * 0.15);
        }
        else if(income > 50000 && income <= 75000){
            tax = (float) (income * 0.2);
        }
        else if(income>100000){
            tax = (float) (income * 0.25);
        }
        System.out.println("total tax paid by employee:" + tax);
    }
}