package Java_OOP_June_2024._03_Inheritance._03_Exercise._06_Animals;

public class Tomcat extends Cat {


    private static final String GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
