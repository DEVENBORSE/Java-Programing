import java.util.Scanner;
public class AgeException{
        public static void main(String [] args){
        Scanner sc=new Scanner (System.in);

        System.out.println("enter your age:");
        int age = sc.nextInt();

        try{
            checkAge(age);
            System.out.println("your age is:"+age);

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        sc.close();
    }

    public static void checkAge(int age) throws Exception{
        if(age < 0){
            throw new Exception("Age cannot be negative!");
        }
    }
}