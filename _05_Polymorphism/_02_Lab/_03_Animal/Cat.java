package Java_OOP_June_2024._05_Polymorphism._02_Lab._03_Animal;

public class Cat extends Animal {

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s MEEOW", super.explainSelf());
    }
}
