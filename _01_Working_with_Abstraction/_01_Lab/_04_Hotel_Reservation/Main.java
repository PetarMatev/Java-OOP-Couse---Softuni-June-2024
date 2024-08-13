package Java_OOP_June_2024._01_Working_with_Abstraction._01_Lab._04_Hotel_Reservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] info = scan.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(info[0]);
        int numberOfDays = Integer.parseInt(info[1]);
        Season season = Season.valueOf(info[2].toUpperCase());
        DiscountType discountType = DiscountType.fromString(info[3]);
        PriceCalculator calculate = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);
        System.out.println(calculate.getPriceForWholePeriod());
    }
}
