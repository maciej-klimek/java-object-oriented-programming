import jdk.jfr.Experimental;

import java.util.Scanner;

public class DrawTriangle {

    public static void draw(int length) {
        length = length-2;
        int line = 1;
        for (int j = 0; j < length; j++) {
            System.out.print(" ");
        };
        System.out.print("#");
        System.out.println();

        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length - line; j++) {
                System.out.print(" ");
            }
            System.out.print("#");
            for (int j = 0; j < 2 * line -1; j++) {
                System.out.print(" ");
            }
            System.out.print("#");
            System.out.println();
            line++;
        }
        for (int j = 0; j < length+line; j++) {
            System.out.print("#");
        };
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj dlugosc boku: ");
        try {
            int userInput = Integer.parseInt(scanner.nextLine());
            if (userInput > 0 ) {
                draw(userInput);
            }
            else {
                System.out.println("Nieprawidlowa dlugosc boku");
            }
        }
        catch (Exception e) {
            System.out.println("Nieprawidlowy argument");
        }

        scanner.close();
    }
}
