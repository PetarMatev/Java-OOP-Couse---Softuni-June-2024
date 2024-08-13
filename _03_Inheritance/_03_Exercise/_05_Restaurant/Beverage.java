package Java_OOP_June_2024._03_Inheritance._03_Exercise._05_Restaurant;

import java.math.BigDecimal;

public class Beverage extends Product{

    private double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }
}
