package Java_OOP_June_2024._04_Interfaces_and_Abstraction._02_Lab.border_controll;

public class Robot implements Identifiable {

    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }


    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}
