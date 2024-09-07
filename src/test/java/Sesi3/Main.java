package Sesi3;


class Vehicle{
    //property
    String brand;
    String model;
    int year;


    public Vehicle (String brandName, String modelVehicle, int yearVehicle) throws InvalidYearsException {
        this.brand = brandName;
        this.model = modelVehicle;
        this.year = yearVehicle;

        checkYear(yearVehicle);
    }

    void checkYear(int year) throws InvalidYearsException {

        if(year > 2024){
            throw new InvalidYearsException("The vehicle year shouldn't be more than current year");
        }else{
            System.out.println("The vehicle age is good");
        }

    }


    void vehicleSound(){
        System.out.println("This is the sound of the Vehicle: " + this.brand + " " + this.model + " " + this.year);
    }
}

class InvalidYearsException extends Exception{

    public InvalidYearsException (String yearCheck){
        super(yearCheck);
    }

}


class Car extends Vehicle {
    int numOfDoors;

   public Car(String brand, String model, int year, int numOfDoor) throws InvalidYearsException {
       super(brand, model, year);
       this.numOfDoors = numOfDoor;
   }

    @Override
    void vehicleSound() {
        System.out.println("This is the sound of the Car: " + this.brand + " " + this.model + " " + this.year);
        System.out.println("Number of Doors: " + this.numOfDoors);
    }
}

class Motorcycle extends Vehicle{
    Boolean hasSidecar;

    public Motorcycle(String brandName, String modelVehicle, int yearVehicle, boolean hassideCar) throws InvalidYearsException {
        super(brandName, modelVehicle, yearVehicle);
        this.hasSidecar = hassideCar;
    }

    void vehicleSound() {
        System.out.println("This is the sound of the Motorcycle: " + this.brand + " " + this.model + " " + this.year);
        System.out.println("Number of Sidecar: " + this.hasSidecar);
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            Vehicle obj = new Vehicle("Suzuki", "Celerio", 2025);
            obj.vehicleSound();
            System.out.println("\n");

            Car obj2 = new Car("Toyota", "Corolla", 2020, 4);
            obj2.vehicleSound();
            System.out.println("\n");


            Motorcycle obj3 = new Motorcycle("Toyota", "Corolla", 2020, false);
            obj3.vehicleSound();
            System.out.println("\n");

        } catch (InvalidYearsException e) {
            System.out.println(e.getMessage());
        }
    }
}
