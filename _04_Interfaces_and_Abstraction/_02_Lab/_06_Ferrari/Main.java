package Java_OOP_June_2024._04_Interfaces_and_Abstraction._02_Lab._06_Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String driverName = scan.nextLine();
        Car myCar = new Ferrari(driverName);
        System.out.println(myCar);
    }
}
