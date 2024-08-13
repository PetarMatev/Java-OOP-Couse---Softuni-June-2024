package Java_OOP_June_2024._01_Working_with_Abstraction._01_Lab._04_Hotel_Reservation;

public enum Season {
    SPRING(2),
    SUMMER(4),
    AUTUMN(1),
    WINTER(3);

    private final int period;

    Season(int period) {
        this.period = period;
    }

    public int getPeriod() {
        return this.period;
    }
}
