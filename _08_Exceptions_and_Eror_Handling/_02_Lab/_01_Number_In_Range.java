package Java_OOP_June_2024._08_Exceptions_and_Eror_Handling._02_Lab;

import java.util.Optional;
import java.util.Scanner;

public class _01_Number_In_Range {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rangeNums = scan.nextLine().split("\\s+");
        int rangeStart = Integer.parseInt(rangeNums[0]);
        int rangeEnd = Integer.parseInt(rangeNums[1]);
        System.out.printf("Range: [%d...%d]%n", rangeStart, rangeEnd);

        String input = scan.nextLine();
        while (!validInput(input, rangeStart, rangeEnd)) {
            input = scan.nextLine();
        }
    }

    private static boolean validInput(String input, int rangeStart, int rangeEnd) {
        Optional<Integer> number = Optional.empty();

        try {
            number = Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException ignored) {
        }

        boolean numberIsValid = number.isPresent()
                && number.get() >= rangeStart
                && number.get() <= rangeEnd;

        String output = numberIsValid?
                String.format("Valid number: %d", number.get())
                : String.format("Invalid number: %s", input);

        System.out.println(output);
        return numberIsValid;
    }
}
