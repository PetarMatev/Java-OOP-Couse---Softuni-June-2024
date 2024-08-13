package Java_OOP_June_2024._03_Inheritance._03_Exercise._05_Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish{

    private static final double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);

    }
}
