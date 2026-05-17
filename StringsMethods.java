import java.lang.*;
import java.util.Scanner;

public class StringsMethods{
    public static void main(String[] args){
        String name = new String("Harry");
        System.out.println(name);

        int a=6;
        float b= 5.6454f;
        System.out.printf("the value of a is %d and the value of b is %8.2f", a,b);
        System.out.println();

        Scanner sc =new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s);


        int value = name.length();
        System.out.println(value);


        String lstring = name.toLowerCase();
        System.out.println(lstring);


        String ustring = name.toUpperCase();
        System.out.println(ustring);


        String nonTrimmedString = "     Harry    ";
        System.out.println(nonTrimmedString);
        String trimmedString = nonTrimmedString.trim();     //--> trims the spaces
        System.out.println(trimmedString);


        //System.out.println(name.replace('r','p'));
        System.out.println(name.replace("r","app"));


        System.out.println(name.startsWith("Har"));
        System.out.println(name.endsWith("dd"));


        System.out.println(name.charAt(0));
        System.out.println(name.charAt(4));

        String modifiedName = "Harryrry";
        System.out.println(modifiedName.indexOf("rry"));
        System.out.println(modifiedName.indexOf("rry",4));
        System.out.println(modifiedName.lastIndexOf("rry"));


        System.out.println(name.equals("Harry"));
        System.out.println(name.equalsIgnoreCase("harry"));


        String letter = "Dear <|name|>, Thanks a lot!.";
        letter = letter.replace("<|name|>", "Deven");
        System.out.println(letter);

        String me = " the spaces is  double and   triple";
        System.out.println(me.indexOf("  "));
        System.out.println(me.indexOf("   "));

        String Dev = "Dear Deven \n\tthis java practice is nice.\n\tThankyou";
        System.out.println(Dev);
        
    }
    
}