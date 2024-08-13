package Java_OOP_June_2024._01_Working_with_Abstraction._02_Exercise._03_Cards_with_Power;

public enum Suit {

    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private final int card;

    Suit(int card) {
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
