import jdk.jfr.Experimental;

import java.util.Scanner;

public class DrawSquare {

    public static void draw(int length) {
        for (int i = 0; i < length; i ++) {
            System.out.print("#");
        }


        for (int i = 0; i < length; i ++) {
            System.out.println();
            System.out.print("#");
            for (int j = 0; j < length-2; j ++) {
                System.out.print(" ");
            }
            System.out.print("#");
        }

        System.out.println();
        for (int i = 0; i < length; i ++) {
            System.out.print("#");
        }
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
