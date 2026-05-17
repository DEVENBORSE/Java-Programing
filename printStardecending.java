import java.lang.*;
import java.util.Scanner;

class printStardecending{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the n number:");
        int n=sc.nextInt();
        for(int i=n;i>0;i--){
            for(int j=0;j<i;j++){
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }
}