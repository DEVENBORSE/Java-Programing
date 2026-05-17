import java.lang.*;

class Student{
    int roll_No;
    String name;

    Student(int r, String n){
        roll_No = r;
        name = n;
    }

    void display(){
        System.out.println("Roll No: " + roll_No);
        System.out.println("Name: " + name);
    }
}

class Exam extends Student{
    String Sub_name;

    Exam(int r, String n, String s){
        super(r, n);
        Sub_name=s;
    }

    void display1(){
        display();
        System.out.println("Subject Name:"+Sub_name);
    }
}

class SingleInheritanceStu{
    public static void main(String[] args) {
        Exam e = new Exam(1, "Rahul", "Maths");
        e.display1();
    }
}