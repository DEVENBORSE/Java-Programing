import java.lang.*;

interface Animal{
    void sound();
    void eat();
    void sleep();
}

class Dog implements Animal{
    public void sound(){
        System.out.println("Dog Barks!");

    }

    public void eat(){
        System.out.println("Dog Eats!");
    }

    public void sleep(){
        System.out.println("Dog Sleeps!");
    }
}

class Cat implements Animal{
    public void sound(){}
    
    public void eat(){
        System.out.println("Cat Eats!");
    }

    public void sleep(){
        System.out.println("Cat Sleeps");
    }
}

public class Interface{
    public static void main(String[] args){
        Dog d = new Dog();
        Cat c = new Cat();
        
        d.sound();
        d.eat();
        d.sleep();

        c.eat();
        c.sleep();
    }
}