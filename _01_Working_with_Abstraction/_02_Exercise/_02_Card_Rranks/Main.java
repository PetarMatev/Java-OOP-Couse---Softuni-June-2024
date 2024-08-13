package Java_OOP_June_2024._01_Working_with_Abstraction._02_Exercise._02_Card_Rranks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if ("Card Ranks".equals(input)) {
            Suits.printAllRanks();
        } else {
            System.out.println("Invalid input");
        }
    }
}
