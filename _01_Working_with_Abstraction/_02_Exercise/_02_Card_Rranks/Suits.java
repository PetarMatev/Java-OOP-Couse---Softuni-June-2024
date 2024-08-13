package Java_OOP_June_2024._01_Working_with_Abstraction._02_Exercise._02_Card_Rranks;

public enum Suits {

    ACE(0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7),
    NINE(8),
    TEN(9),
    JACK(10),
    QUEEN(11),
    KING(12);

    private final int card;

    Suits(int card) {
        this.card = card;
    }

    public int getCard() {
        return card;
    }

    public String getName() {
        return this.name();
    }

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s", getCard(), getName());
    }

    public static void printAllRanks() {
        System.out.println("Card Ranks:");
        for (Suits suit : Suits.values()) {
            System.out.println(suit.toString());
        }
    }
}
