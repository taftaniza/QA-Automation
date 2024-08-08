public class Animal {

    public void sound(){
        System.out.println("Animal sound");
    }
}

//Inheritance
class Title extends Animal{
    public static void main(String[] args) {
        Title x = new Title();
        x.sound();
    }
}

// Polymorphism
class Cat extends Animal{
    public void sound(){
        System.out.println("Meow Meow");
    }
}
class Dog extends Animal{
    public void sound(){
        System.out.println("Guk Guk");
    }
}



