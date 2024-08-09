import java.util.Scanner;

public class Sesi2
{


    public void Triangle (int height){

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

        switch (choice){
            case 1:
                System.out.println("Enter the height of the triangle: ");
                int height = input.nextInt();
                System.out.println("Enter the height of the triangle: "+ height);
                Sesi2 a = new Sesi2();
                a.Triangle(height);

            case 2:
                System.out.println("Enter the edge of the square: ");
                int edge = input.nextInt();
                System.out.println("Enter the edge of the square: "+ edge);
                Sesi2 b = new Sesi2();
                b.Square(edge);

            case 3:
                System.out.println("Enter the length of the rectangle: ");
                int length = input.nextInt();
                System.out.println("Enter the width of the rectangle: ");
                int width = input.nextInt();
                System.out.println("length: "+ length);
                System.out.println("width: "+ width);
                Sesi2 c = new Sesi2();
                c.Rectangle(length, width);

            case 4:
                System.exit(0);

            default:
                System.out.println("Your option not in the list");

        }
    }
}
