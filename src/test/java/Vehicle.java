//Sesi 3's Answer

import Sesi3.InvalidYearException;

import java.time.Year;

// Base class Vehicle
public class Vehicle {
    String brand;
    String model;
    int year;

   public Vehicle(String brand, String model, int year) throws InvalidYearException {
       this.brand = brand;
       this.model = model;
       this.year = year;

        int currentYear = Year.now().getValue();

        if (year > currentYear) {
            throw new InvalidYearException("Year shouldn't be more than the current year");
        }
    }

    public String vehicleSound() {

        return "Vehicle sound";

    }
}

//Polymorphism:

// Subclass Car
class Car extends Vehicle{
    String carBrand;

    // Constructor for Car
    public Car(String brand, String model, int year, String carBrand) throws InvalidYearException {
        super(brand, model, year);  // Call the constructor of the superclass Vehicle
        this.carBrand = carBrand;
    }


    @Override
    public String vehicleSound() {
        return "Broom broom car";
    }
}

// Subclass Motorcycle
class Motorcycle extends Vehicle {
    String motorColor;

    // Constructor for Motorcycle
    public Motorcycle(String brand, String model, int year, String motorColor) throws InvalidYearException {
        super(brand, model, year);  // Call the constructor of the superclass Vehicle
        this.motorColor = motorColor;
    }

    @Override
    public String vehicleSound() {
        return "Vroom Vroom motorcycle";
    }
}

// Main class to demonstrate polymorphism
class Main {

    public static void main(String[] args) {
        try {
            Vehicle myVehicle = new Vehicle("Generic", "Model X", 2023);
            Vehicle a = new Car("Toyota", "Corolla", 2024, "Toyota");
            Vehicle b = new Motorcycle("Honda", "CBR", 2025, "Red");

            System.out.println(myVehicle.vehicleSound());
            System.out.println(a.vehicleSound());
            System.out.println(b.vehicleSound());

        } catch (InvalidYearException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}