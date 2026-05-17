import java.lang.*;
import java.util.Scanner;

public class Leapyear{
    
    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the year:");
        i = sc.nextInt();

        if(i%4 == 0 && i%100 !=0  ||  i%400 == 0){
            System.out.println(i +" is a leap year");
        }
        else{
            System.out.println(i +" is not a leap year");
        }
    }
}

// another method of showing thw leap year

// System.out.println("enter the leap year:");
// int year = sc.nextInt();
// Boolean isleapyear = (i%4 == 0 && i%100 !=0  ||  i%400 == 0);
// System.out.println(isleapyear+" is a leap year");