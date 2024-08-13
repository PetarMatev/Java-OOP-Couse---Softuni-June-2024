package Java_OOP_June_2024._04_Interfaces_and_Abstraction._02_Lab._02_Car_Shop_Extended;

public class Audi extends CarImpl implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return null;
    }

    @Override
    public Double getPricePerDay() {
        return null;
    }


    @Override
    public String toString() {
        return String.format("Minimum rental period of " + minRentDay + " days. Price per day " + pricePerDay);
    }
}



