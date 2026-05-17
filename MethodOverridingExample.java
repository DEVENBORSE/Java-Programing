// Superclass: Animal
class Animal {
    // Method to be overridden
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass: Dog (overrides makeSound method)
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

// Subclass: Cat (overrides makeSound method)
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

// Main class
public class MethodOverridingExample {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog(); // Polymorphism
        Animal myCat = new Cat();

        myAnimal.makeSound(); // Calls Animal's method
        myDog.makeSound();    // Calls Dog's overridden method
        myCat.makeSound();    // Calls Cat's overridden method
    }
}

