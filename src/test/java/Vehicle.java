public class Vehicle {
    String brand= "Vehicle";
    String model= "Pajero";
    int year= 2024;

    public String vehicleSound(){
        return "Vehicle Sound";
    }
}

//Polymorphism
class Car extends Vehicle {
    String carBrand="Hyundai";

    @Override
    public String vehicleSound(){

        return "Car sounds";
    }
}

class Motorcycle extends Vehicle {
    String motorColor= "Black";

    @Override
    public String vehicleSound(){
        return "Motorcycle sounds";
    }

}

class Main{
    public static void main(String[] args) {
        Vehicle a = new Vehicle();
        Vehicle b = new Car();
        Vehicle c = new Motorcycle();


        System.out.println(a.vehicleSound());
        System.out.println(b.vehicleSound());
        System.out.println(c.vehicleSound());

    }
}
