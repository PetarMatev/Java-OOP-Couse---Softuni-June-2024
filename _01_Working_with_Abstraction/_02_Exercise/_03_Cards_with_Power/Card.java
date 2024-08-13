package Java_OOP_June_2024._01_Working_with_Abstraction._02_Exercise._03_Cards_with_Power;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getCardPower() {
        return rank.getPower() + suit.getPower();
    }

    public void printCardPower() {
        String report = String.format("Card name: %s of %s; Card power: %d", getRank(), getSuit(), getCardPower());
        System.out.println(report);
    }

}
