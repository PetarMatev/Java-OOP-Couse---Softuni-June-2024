package Java_OOP_June_2024._05_Polymorphism._02_Lab._03_Animal;

public class Dog extends Animal {

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s DJAAF", super.explainSelf());
    }
}
