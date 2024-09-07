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

        System.out.println("The vehicle brand is: "+ brand);
        System.out.println("The vehicle model is: "+ model);

        if(year > 2024){
            throw new InvalidYearsException("The car year shouldn't be more than current year");
        }else{
            System.out.println("The vehicle year is: "+ year);
        }
    }

    void vehicleSound(){
        System.out.println("This is the sound of the Vehicle");
    }
}

class InvalidYearsException extends Exception{

    public InvalidYearsException (String yearCheck){
        super(yearCheck);
    }

}


class Car extends Vehicle {
    int numOfDoors;

    public Car(String brandName, String modelVehicle, int yearVehicle) throws InvalidYearsException {
        super(brandName, modelVehicle, yearVehicle);
    }

    void vehicleSound () {
            System.out.println("This is the sound of the Car");
        }
}

class Motorcycle extends Vehicle{
    Boolean hasSidecar;

    public Motorcycle(String brandName, String modelVehicle, int yearVehicle) throws InvalidYearsException {
        super(brandName, modelVehicle, yearVehicle);
    }

    void vehicleSound() {
        System.out.println("This is the sound of the Motorcycle");
    }
}


public class Main {
    public static void main(String[] args) throws InvalidYearsException {
        Vehicle obj = new Vehicle("Suzuki", "Celerio", 2020);
        obj.vehicleSound();

        Car obj2 = new Car("Toyota", "Luxury", 2025);
        obj2.vehicleSound();

        Motorcycle obj3 = new Motorcycle("Yamaha", "Mito", 2021);
        obj3.vehicleSound();

    }

}
