package Java_OOP_June_2024._04_Interfaces_and_Abstraction._03_Exercise._03_Birthday_Celebrations;

public class Robot implements Identifiable {

    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return id;
    }
}
