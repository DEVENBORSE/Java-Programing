public class Printf {
    public static void main(String[] args) {

        //printf() --> is a method used to format output

        // %[flags][width][.precision][specifier-character]

        String name = "Spongebob";
        char firstletter = 'S';
        int age = 30;
        double height = 60.5;
        boolean isEmployed = true;

        System.out.printf("hello %s\n", name);
        System.out.printf("The first letter of your name is: %c\n", firstletter);
        System.out.printf("You are %d years old.\n", age);
        System.out.printf("Your height is %.1f inches.\n", height);
        System.out.printf("Are you employed? %b\n", isEmployed);

        System.out.printf("%s is %d years old.\n", name, age);


        // flags
        // + = output a plus
        // , = comma grouping separator
        // ( = negative numbers are enclosed in ()
        // space = display a minus if negative, space if positive

        double price1 = 9.99;
        double price2 = 19.99;
        double price3 = -54.01;

        System.out.printf("%+.2f\n", price1);
        System.out.printf("%+.2f\n", price2);
        System.out.printf("%+.2f\n", price3);

        double price4 = 9000.99;
        double price5 = 19000.99;
        double price6 = -54000.01;

        System.out.printf("%,.2f\n", price4);
        System.out.printf("%,.2f\n", price5);
        System.out.printf("%,.2f\n", price6);

        double price7 = 9.99;
        double price8 = 19.99;
        double price9 = -54.01;

        System.out.printf("%(.2f\n", price7);
        System.out.printf("%(.2f\n", price8);
        System.out.printf("%(.2f\n", price9);
        

        // width
        // 0 = zero padding
        // number = right justify padding
        // negative number = left justify padding

        int id1 = 1;
        int id2 = 23;
        int id3 = 456;
        int id4 = 7890;

        System.out.printf("%04d\n", id1);
        System.out.printf("%04d\n", id2);
        System.out.printf("%04d\n", id3);
        System.out.printf("%04d\n", id4);


        System.out.printf("%4d\n", id1);
        System.out.printf("%4d\n", id2);
        System.out.printf("%4d\n", id3);
        System.out.printf("%4d\n", id4);


        System.out.printf("%-4d\n", id1);
        System.out.printf("%-4d\n", id2);
        System.out.printf("%-4d\n", id3);
        System.out.printf("%-4d\n", id4);

    }
}