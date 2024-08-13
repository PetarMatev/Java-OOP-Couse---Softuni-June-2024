package Java_OOP_June_2024._04_Interfaces_and_Abstraction._02_Lab._03_Say_Hello;

public class European implements Person{

    private String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

}
