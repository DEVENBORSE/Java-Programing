import java.lang.*;
import java.util.Scanner;
class Person{
    String name;
    int age;

    Scanner sc= new Scanner(System.in);
    Person(){
        System.out.println("enter the name:");
        name=sc.nextLine();
        System.out.println("enter the age:");
        age=sc.nextInt();
    }

    void display(){
        System.out.println("Name:"+name);
        System.out.println("age:"+age);
    }

}

class Student extends Person{
    int roll_No;
    float marks;

    Student(){
        System.out.println("enter the roll no:");
        roll_No=sc.nextInt();
        System.out.println("enter the marks of student:");
        marks=sc.nextFloat();
    }

    void display1(){
        display();
        System.out.println("Roll no."+roll_No);
        System.out.println("marks:"+marks);
    }
}

class SingleInheritanceFromUser{
    public static void main(String[] args) {
        Student s= new Student();
        s.display1();
    }
}