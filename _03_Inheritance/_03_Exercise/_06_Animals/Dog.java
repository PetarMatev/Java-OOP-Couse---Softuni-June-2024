package Java_OOP_June_2024._03_Inheritance._03_Exercise._06_Animals;

public class Dog extends Animal {
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
         return "Woof!";
    }
}
