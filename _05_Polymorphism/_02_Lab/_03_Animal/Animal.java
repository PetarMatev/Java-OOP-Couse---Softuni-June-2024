package Java_OOP_June_2024._05_Polymorphism._02_Lab._03_Animal;

public abstract class Animal {
    protected String name;
    protected String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s",
                name,
                favouriteFood);
    }
}
