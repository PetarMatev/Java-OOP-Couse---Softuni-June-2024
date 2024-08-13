package Java_OOP_June_2024._02_Encapsulation._03_Exercise._02_Animal_Farm;

public class Chicken {
    private String name;
    private int age;


    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.equals(" ") || name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    private String getName() {
        return name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        } else {
            this.age = age;
        }
    }

    private int getAge() {
        return age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (getAge() >= 0 && getAge() <= 5) {
            return 2;
        } else if (getAge() >= 6 && getAge() <= 11) {
            return 1;
        } else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", getName(), getAge(), productPerDay());
    }
}
