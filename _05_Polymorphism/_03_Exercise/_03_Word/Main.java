package Java_OOP_June_2024._05_Polymorphism._03_Exercise._03_Word;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        CommandInterface commandInterface = Initialization.buildCommandInterface(text);

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("exit")) {
            // cut 1 7
            commandInterface.handleInput(inputLine);
            inputLine = scanner.nextLine();
        }

        System.out.println(text);
    }
}
