package Java_OOP_June_2024._03_Inheritance._03_Exercise._05_Restaurant;

import java.math.BigDecimal;

public class Food extends Product{

    private double grams;

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }
}
