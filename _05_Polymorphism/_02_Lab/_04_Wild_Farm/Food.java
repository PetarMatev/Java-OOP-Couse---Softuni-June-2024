package Java_OOP_June_2024._05_Polymorphism._02_Lab._04_Wild_Farm;

public abstract class Food {

    private final Integer quantity;

    protected Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
