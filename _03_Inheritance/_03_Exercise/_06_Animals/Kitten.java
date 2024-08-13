package Java_OOP_June_2024._03_Inheritance._03_Exercise._06_Animals;

public class Kitten extends Cat{

    private final static String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
