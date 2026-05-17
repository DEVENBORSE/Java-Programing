class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

// Dog class inherits from Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks.");
    }
}

// Cat class also inherits from Animal
class Cat extends Animal {
    void meow() {
        System.out.println("Cat meows.");
    }
}

public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat();
        myDog.bark();

        Cat myCat = new Cat();
        myCat.eat();
        myCat.meow();
    }
}
