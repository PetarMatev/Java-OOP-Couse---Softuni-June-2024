package Java_OOP_June_2024._02_Encapsulation._03_Exercise._04_Pizza_Calories;

public enum ToppingModifier {
    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);

    private final double modifier;

    ToppingModifier(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
