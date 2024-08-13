package Java_OOP_June_2024._04_Interfaces_and_Abstraction._02_Lab._02_Car_Shop_Extended;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s sells for %.2f", getModel(), getPrice());
    }
}
