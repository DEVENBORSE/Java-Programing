import java.lang.*;
import java.util.Scanner;

public class Student{
    int Stud_Id;
    String Stud_Name;
    String Stud_Address;

    public void get_data(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID:");
        Stud_Id = sc.nextInt();
        System.out.println("Enter Student Name:");
        Stud_Name = sc.next();
        System.out.println("Enter Student Address:");
        Stud_Address = sc.next();
    }

    public void display_data(){
        System.out.println("Student ID: " + Stud_Id);
        System.out.println("Student Name: " + Stud_Name);
        System.out.println("Student Address: " + Stud_Address);
    }

    public static void main(String[] args){
        Student s = new Student();
        s.get_data();
        s.display_data();
    }
}