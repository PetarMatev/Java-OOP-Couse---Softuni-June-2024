package Java_OOP_June_2024._04_Interfaces_and_Abstraction._02_Lab._04_Say_Hello_Extended;

public abstract class BasePerson implements Person {

    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
