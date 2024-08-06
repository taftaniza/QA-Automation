public class Animal {
    String name="Cat";


    public void sound(){
        System.out.println("Meow meow");
    }
}

//Inheritance
class Cat extends Animal{
    public static void main (String[] args){
        Cat a = new Cat();
        a.sound();
        System.out.println("Is the sound of: " + a.name);
    }
}

// Polymorphism
class Dog extends Animal{
    public void sound(){
        System.out.println("Guk Guk");
    }
}



