class Student {
    String name = "Deven";
    int rollNo = 17;

    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }
}

interface Exam {
    void showMarks();
}

class Result extends Student implements Exam {
    int marks = 88;

    public void showMarks() {
        System.out.println("Exam Marks: " + marks);
    }

    public static void main(String[] args) {
        Result result = new Result();
        result.displayDetails();
        result.showMarks();
    }
}

