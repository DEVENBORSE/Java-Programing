// Superclass (Parent Class)
class Vehicle {
    String brand;

    // Constructor
    Vehicle(String brand) {
        this.brand = brand;
    }

    // Method to be overridden
    void displayInfo() {
        System.out.println("This is a vehicle of brand: " + brand);
    }
}

// Subclass 1 (Inheritance + Method Overriding)
class Car extends Vehicle {
    int speed;

    Car(String brand, int speed) {
        super(brand); // Call parent constructor
        this.speed = speed;
    }

    @Override
    void displayInfo() {
        System.out.println("Car Brand: " + brand + ", Speed: " + speed + " km/h");
    }
}

// Subclass 2 (Inheritance + Method Overriding)
class Bike extends Vehicle {
    boolean hasGear;

    Bike(String brand, boolean hasGear) {
        super(brand);
        this.hasGear = hasGear;
    }

    @Override
    void displayInfo() {
        System.out.println("Bike Brand: " + brand + ", Has Gear: " + (hasGear ? "Yes" : "No"));
    }
}

// Subclass 3 (Inheritance + Method Overriding)
class Truck extends Vehicle {
    int loadCapacity;

    Truck(String brand, int loadCapacity) {
        super(brand);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("Truck Brand: " + brand + ", Load Capacity: " + loadCapacity + " tons");
    }
}

// Main Class to demonstrate Inheritance and Polymorphism
public class InheritancePolymorphismDemo{
    public static void main(String[] args) {
        // Using superclass reference to hold subclass objects (Runtime Polymorphism)
        Vehicle myVehicle;

        myVehicle = new Car("Toyota", 180);
        myVehicle.displayInfo(); // Calls Car's overridden method

        myVehicle = new Bike("Yamaha", true);
        myVehicle.displayInfo(); // Calls Bike's overridden method

        myVehicle = new Truck("Volvo", 10);
        myVehicle.displayInfo(); // Calls Truck's overridden method
    }
}
