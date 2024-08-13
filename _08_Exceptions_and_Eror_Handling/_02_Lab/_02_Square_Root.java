package Java_OOP_June_2024._08_Exceptions_and_Eror_Handling._02_Lab;

import java.util.Scanner;

public class _02_Square_Root {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int number = -1;

        try {

            number = Integer.parseInt(input);
        } catch (NumberFormatException ignored) {
        }

        if (number >= 0) {
            double sqrt = Math.sqrt(number);
            System.out.printf("%.2f%n", sqrt);
        } else {
            System.out.println("Invalid");
        }

        System.out.println("Goodbye");
    }
}
