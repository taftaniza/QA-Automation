import java.util.Scanner;

public class Practical1
{
    public int value;

    public void Triangle (int height){
        this.value=height;

        for(int i = 1; i<=height; i++){
            for(int j = i; j<height; j++){
                System.out.print(" ");
            }
            for(int k =1; k<=(2 * i -1); k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void Square(int edge){
        this.value=edge;
        for (int i = 1; i <= edge; i++) {
            for (int j = 1; j <= edge; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void Rectangle(int length, int width){
        for(int i = 1; i<=width; i++){
            for(int j = 1; j<=length; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {

        System.out.println("Welcome to ASCII Shape Drawer\n");

        Scanner input = new Scanner(System.in);
        System.out.println("Choose a shape to draw:");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.println("3. Rectangle");
        System.out.println("4. Exit");

        System.out.println("Enter your choice: ");
        int choice = input.nextInt();
        System.out.println("Enter your choice: " + choice);

        if (choice == 1) {
            System.out.println("Enter the height of the triangle: ");
            int height = input.nextInt();
            System.out.println("Enter the height of the triangle: "+ height);
            Practical1 a = new Practical1();
            a.Triangle(height);
        }
        else if(choice==2){
            System.out.println("Enter the edge of the square: ");
            int edge = input.nextInt();
            System.out.println("Enter the edge of the square: "+ edge);
            Practical1 b = new Practical1();
            b.Square(edge);
        }
        else if(choice==3){
            System.out.println("Enter the length of the rectangle: ");
            int length = input.nextInt();
            System.out.println("Enter the width of the rectangle: ");
            int width = input.nextInt();
            System.out.println("length: "+ length);
            System.out.println("width: "+ width);
            Practical1 c = new Practical1();
            c.Rectangle(length, width);

        }
        else if(choice==4){
            System.exit(0);
        }
        else {
            System.out.println("Your option not recognised");

        }
    }
}
