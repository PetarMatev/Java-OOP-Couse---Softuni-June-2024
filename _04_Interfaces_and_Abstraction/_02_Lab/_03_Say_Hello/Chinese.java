package Java_OOP_June_2024._04_Interfaces_and_Abstraction._02_Lab._03_Say_Hello;

public class Chinese implements Person {

    private String name;

    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
