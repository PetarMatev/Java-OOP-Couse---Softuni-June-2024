package Java_OOP_June_2024._03_Inheritance._03_Exercise._06_Animals;

public class Frog extends Animal {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }


    @Override
    public String produceSound() {
        return "Ribbit";
    }
}
