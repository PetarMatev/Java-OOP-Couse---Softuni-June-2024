package Java_OOP_June_2024._01_Working_with_Abstraction._01_Lab._04_Hotel_Reservation;

public class PriceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Season getSeason() {
        return season;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public String getPriceForWholePeriod() {
        double total_price = getPricePerDay() * getNumberOfDays() * getSeason().getPeriod() * getDiscountType().getDiscount();
        return String.format("%.2f", total_price);
    }

}
