package Java_OOP_June_2024._04_Interfaces_and_Abstraction._02_Lab._04_Say_Hello_Extended;

public class European extends BasePerson {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

}
