package Sesi2;

import java.util.Scanner;

public class AsciiShape
{
    Scanner scanner = new Scanner(System.in);

    public void display(){
        System.out.println("Welcome to ASCII Shape Drawer");
        System.out.println("Choose a shape to draw:");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.println("3. Rectangle");
        System.out.println("4. Trapesium");
        System.out.println("5. Diamond");
        System.out.println("6. Exit");
    }

    public void run(){
        while(true){
            display();
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("Enter your choice: " + choice);
            drawShape(choice);

        }
    }


    public void drawShape(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Enter the height of the triangle: ");
                int height = scanner.nextInt();
                System.out.println("Enter the height of the triangle: " + height);
                Triangle(height);
                break;

            case 2:
                System.out.println("Enter the edge of the square: ");
                int edge = scanner.nextInt();
                System.out.println("Enter the edge of the square: " + edge);
                Square(edge);
                break;

            case 3:
                System.out.println("Enter the length of the rectangle: ");
                int length = scanner.nextInt();
                System.out.println("Enter the width of the rectangle: ");
                int width = scanner.nextInt();
                System.out.println("length: " + length);
                System.out.println("width: " + width);
                Rectangle(length, width);
                break;

            case 4:
                System.out.println("Enter the height of the trapesium: ");
                int ltgh = scanner.nextInt();
                System.out.println("Enter the height of the trapesium: " + ltgh);
                Trapesium(ltgh);
                break;

            case 5:
                System.out.println("Enter the height of the diamond: ");
                int lght = scanner.nextInt();
                System.out.println("Enter the height of the diamond: " + lght);
                Diamond(lght);
                break;

            case 6:
                System.exit(0);

            default:
                System.out.println("Invalid choice");
        }
    }

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

    public void Trapesium(int ltgh){
        int baseWidth = 2 * ltgh; // Adjust this to control the bottom width of the trapezoid

        for (int i = 0; i < ltgh; i++) {
            for (int j = 0; j < ltgh - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < baseWidth + 2 * i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void Diamond(int lght) {
        for (int i = 0; i < lght; i++) {
            for (int j = i; j < lght-1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (2*i+1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < lght-1; i++) {
            for (int j = i; j < (2*i+1); j++) {
                System.out.print(" ");
            }
            for(int k =lght-1; k >= (2*i); k--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }



    public static void main (String[] args)
    {
        AsciiShape menu = new AsciiShape();
        menu.run();

    }

}
