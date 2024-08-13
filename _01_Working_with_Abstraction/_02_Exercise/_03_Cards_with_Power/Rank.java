package Java_OOP_June_2024._01_Working_with_Abstraction._02_Exercise._03_Cards_with_Power;

public enum Rank {

    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private final int card;

    Rank(int card) {
        this.card = card;
    }

    public int getPower() {
        return card;
    }

    public String getName() {
        return this.name();
    }

    @Override
    public String toString() {
        return getName();
    }
}
