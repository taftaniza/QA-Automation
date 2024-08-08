//Polymorphism
public class Test extends Animal {

    public void sound(){
        System.out.println("Kwek Kwek");
    }

    public static void main(String[] args){
        //Polymorphism (File: Animal.java)
        Animal a = new Cat();
        Animal b = new Dog();
        Animal c = new Test();

        a.sound();
        b.sound();
        c.sound();

    }



}