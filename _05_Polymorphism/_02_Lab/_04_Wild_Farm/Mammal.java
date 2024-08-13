package Java_OOP_June_2024._05_Polymorphism._02_Lab._04_Wild_Farm;

public abstract class Mammal extends Animal {

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public boolean canEat(Food food) {
        return food.getClass().getSimpleName().equals("Vegetable");
    }
}
