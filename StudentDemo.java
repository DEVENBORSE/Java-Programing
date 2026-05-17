import java.lang.*;

class Student {
    int rollNo;
    String name;
    int marks;

    void setData(int r, String n, int m) {
        rollNo = r;
        name = n;
        marks = m;
    }

    void getData() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}


public class StudentDemo {
    public static void main(String[] args) {
        
        Student student = new Student();
        student.setData(101, "Alice", 85);
        student.getData();
    }
}
