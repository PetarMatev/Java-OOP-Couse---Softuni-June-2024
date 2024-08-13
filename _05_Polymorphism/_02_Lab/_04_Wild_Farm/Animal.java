package Java_OOP_June_2024._05_Polymorphism._02_Lab._04_Wild_Farm;

import java.text.DecimalFormat;

public abstract class Animal {
    private final String animalName;
    private final String animalType;
    private final Double animalWeight;
    private Integer foodEaten;
    private String livingRegion;

    protected Animal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
        this.livingRegion = livingRegion;
    }

    public abstract void makeSound();

    public abstract boolean canEat(Food food);

    public void eat(Food food) {
        if (canEat(food)) {
            foodEaten += food.getQuantity();
        } else {
            System.out.println(getClass().getSimpleName() + "s are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]",
                getClass().getSimpleName(),
                animalName,
                decimalFormat.format(animalWeight),
                livingRegion,
                foodEaten);
    }
}
