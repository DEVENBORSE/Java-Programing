import java.util.*;

class Vehicle{
    void startEngine(){
        System.out.println("The Engione started of Ertiga");
    }
}

class Ertiga extends Vehicle{
    void offEngine(){
        System.out.println("The engine is off");
} 

class Inheritance{
    public static void main(String[] args){
    Ertiga er = new Ertiga();
    er.startEngine();
    er.offEngine();
    }
}
