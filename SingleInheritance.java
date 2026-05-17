import java.lang.*;

class Person{
    String name;
    int age;

    Person(String n, int a){
        name = n;
        age = a;
    }

    void display(){
        System.out.println("Name: " + name);
        System.out.println("age:"+age);
    }
}

class Student extends Person{
    int roll_no;
    int marks;

    Student(String n, int a, int r, int m){
        super(n,a);
        roll_no=r;
        marks=m;
    }

    void display1(){
        display();
        System.out.println("roll no.:"+roll_no);
        System.out.println("marks:"+marks);
    }
}

class SingleInheritance{
    public static void main(String[] args) {
    Student s1=new Student("Deven",19,17,90);
    s1.display1();
    }
}