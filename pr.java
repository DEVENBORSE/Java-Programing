import java.lang.*;
import java.util.Scanner;

public class pr{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your age:");
        int age = sc.nextInt();

        try{
            checkAge(age);
            System.out.println("Your age is: "+age);
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public static void checkAge(int age)throws Exception{
        if(age<0){
            throw new Exception("age cannot be negative!");
        }
    }
}