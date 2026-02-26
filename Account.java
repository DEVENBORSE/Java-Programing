import java.lang.*;
import java.util.Scanner;

public class Account{
    int accountNumber;
    String Name;
    double balance;

    public void get_data(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account number:");
        accountNumber = sc.nextInt();
        System.out.println("Enter your name:");
        Name = sc.next();
        System.out.println("Enter the Balance in the acc:");
        balance = sc.nextDouble();
    }

    public void display_data(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Name: "+ Name);
        System.out.println("Balance: "+balance);
    }

    public static void main(String[] args){
        Account a = new Account();
        a.get_data();
        a.display_data();
    }
}