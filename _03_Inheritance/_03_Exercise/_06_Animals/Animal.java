package Java_OOP_June_2024._03_Inheritance._03_Exercise._06_Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String produceSound() {
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equals("Female") || gender.equals("Male")) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("%s%n" + // class name
                        "%s %d %s%n" + // name, age, gender
                        "%s", // produceSound function
                this.getClass().getSimpleName(),
                getName(), getAge(), getGender(),
                this.produceSound());
    }
}
