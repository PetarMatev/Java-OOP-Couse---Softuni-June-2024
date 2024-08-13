package Java_OOP_June_2024._01_Working_with_Abstraction._01_Lab._02_Point_In_Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] coordinates = readArray(scan);

        Rectangle rectangle = new Rectangle(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
        int pointsCount = Integer.parseInt(scan.nextLine());


        while (pointsCount-- > 0) {
            int[] pointCoordinates = readArray(scan);

            Point p = new Point(pointCoordinates[0], pointCoordinates[1]);

            System.out.println(rectangle.contains(p));
        }


    }

    private static int[] readArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
