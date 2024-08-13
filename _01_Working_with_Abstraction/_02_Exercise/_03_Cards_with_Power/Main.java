package Java_OOP_June_2024._01_Working_with_Abstraction._02_Exercise._03_Cards_with_Power;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rankPowers = scan.nextLine();
        String suitPowers = scan.nextLine();
        Card card = new Card(Rank.valueOf(rankPowers), Suit.valueOf(suitPowers));
        card.printCardPower();
    }
}
