package Java_OOP_June_2024._01_Working_with_Abstraction._01_Lab;

import java.util.Scanner;

public class _01_Rhombus_of_Stars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //read rhombus size
        int size = Integer.parseInt(scan.nextLine());

        //print the rhombus
        printRhombus(size);
    }

    private static void printRhombus(int size) {
        printFirstRhombusPart(size);
        printSecondRhombusPart(size);
    }

    private static void printFirstRhombusPart(int size) {
        for (int allRows = 1; allRows <= size; allRows++) {
            printRow(size, allRows);
        }
    }

    private static void printSecondRhombusPart(int size) {
        for (int allRows = size - 1; allRows >= 1; allRows--) {
            printRow(size, allRows);
        }
    }

    private static void printRow(int size, int allRows) {
        String spaces = " ".repeat(size - allRows);
        System.out.print(spaces);
        for (int currentRow = 0; currentRow < allRows; currentRow++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
