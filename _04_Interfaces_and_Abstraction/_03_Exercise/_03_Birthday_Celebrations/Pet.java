package Java_OOP_June_2024._04_Interfaces_and_Abstraction._03_Exercise._03_Birthday_Celebrations;

public class Pet implements Birthable {
    private String name;
    private String birthDate;


    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
