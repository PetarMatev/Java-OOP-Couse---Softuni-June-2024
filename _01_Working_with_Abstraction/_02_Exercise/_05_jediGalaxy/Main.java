package Java_OOP_June_2024._01_Working_with_Abstraction._02_Exercise._05_jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = readPositions(scan.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = getMatrix(rows, cols);
        populateMatrix(rows, cols, matrix);

        String command = scan.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            // EVIL
            int[] evilPositions = readPositions(scan.nextLine()); //[4, 5] -> Row and Column of Evil
            int rowEvil = evilPositions[0];
            int colEvil = evilPositions[1];
            moveEvil(rowEvil, colEvil, matrix);

            // JEDI
            int[] jediPositions = readPositions(command); //[4, 5] -> Row and Column of Jedi
            int rowJedi = jediPositions[0];
            int colJedi = jediPositions[1];
            int collectedStars = getCollectedStars(rowJedi, colJedi, matrix);
            sum += collectedStars;

            command = scan.nextLine();
        }
        System.out.println(sum);
    }

    private static int getCollectedStars(int rowJedi, int colJedi, int[][] matrix) {
        int countStars = 0;
        while (rowJedi >= 0 && colJedi < matrix[1].length) {
            if (rowJedi < matrix.length && colJedi >= 0 && colJedi < matrix[0].length) {
                countStars += matrix[rowJedi][colJedi];
            }
            colJedi++;
            rowJedi--;
        }
        return countStars;
    }

    private static void moveEvil(int xE, int yE, int[][] matrix) {
        while (xE >= 0 && yE >= 0) {
            if (xE < matrix.length && yE < matrix[0].length) {
                matrix[xE][yE] = 0;
            }
            xE--;
            yE--;
        }
    }

    private static void populateMatrix(int x, int y, int[][] matrix) {
        int value = 0;
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                matrix[row][col] = value++;
            }
        }
    }

    private static int[][] getMatrix(int x, int y) {
        return new int[x][y];
    }

    private static int[] readPositions(String scanner) {
        return Arrays.stream(scanner.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
