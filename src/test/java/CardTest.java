package test.java;

import main.java.entity.Card;
import main.java.entity.FaveValue;
import main.java.entity.Suit;

public class CardTest {

    public static void main(String[] args) {
        CardTest test = new CardTest();
        test.testCardCreation();
        test.testCardToString();
    }

    public void testCardCreation() {
        Card card = new Card(Suit.HEARTS, FaveValue.ACE);

        assert card != null : "Card should not be null.";
        assert card.suit() == Suit.HEARTS : "Card suit should be HEARTS.";
        assert card.faveValue() == FaveValue.ACE : "Card value should be ACE.";

        System.out.println("testCardCreation passed.");
    }

    public void testCardToString() {
        Card card = new Card(Suit.SPADE, FaveValue.KING);
        String s = card.toString();

        assert s.equals("Card[suit=SPADE, faveValue=King]") : "Card string representation should be 'KING of SPADES'.";

        System.out.println("testCardToString passed.");
    }
}
