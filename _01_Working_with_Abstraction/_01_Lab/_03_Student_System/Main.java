package Java_OOP_June_2024._01_Working_with_Abstraction._01_Lab._03_Student_System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (studentSystem.isRunning()) {
            String[] input = scan.nextLine().split("\\s+");
            studentSystem.parseCommand(input);
        }
    }
}
