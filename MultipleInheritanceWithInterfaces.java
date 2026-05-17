interface A {
    void show();
}

interface B {
    void show();
}

// No ambiguity as the method is implemented in class C
class C implements A, B {
    public void show() {
        System.out.println("Implemented show() in Class C");
    }
}

public class MultipleInheritanceWithInterfaces {
    public static void main(String[] args) {
        C obj = new C();
        obj.show(); // No ambiguity
    }
}
