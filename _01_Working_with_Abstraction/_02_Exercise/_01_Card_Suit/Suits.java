package Java_OOP_June_2024._01_Working_with_Abstraction._02_Exercise._01_Card_Suit;

public enum Suits {

    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private final int card;

    Suits(int card) {
        this.card = card;
    }

    public int getCard() {
        return card;
    }

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s", this.card, this.name());
    }

    public static void printAllSuits() {
        System.out.println("Card Suits:");
        for (Suits suit : Suits.values()) {
            System.out.println(suit.toString());
        }
    }
}
