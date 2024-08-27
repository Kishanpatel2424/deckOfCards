package test.java;

import main.java.entity.Card;
import main.java.entity.Deck;
import main.java.interfaces.ShuffleStrategy;
import main.java.interfaces.impl.RandomShuffleStrategy;
import main.java.Exception.EmptyDeckException;
public class DeckTest {

    public static void main(String[] args) {
        DeckTest test = new DeckTest();
        test.testDeckInitialization();
        test.testShuffleDeck();
        test.testDealCard();
        test.testDealAllCards();
        test.testDealCardFromEmptyDeck();
    }

    public void testDeckInitialization() {
        ShuffleStrategy shuffleStrategy = new RandomShuffleStrategy();
        Deck deck = new Deck(shuffleStrategy);

        assert deck != null : "Deck should not be null.";
        assert deck.size() == 52 : "Deck should have 52 cards upon initialization.";

        System.out.println("testDeckInitialization passed.");
    }

    public void testShuffleDeck() {
        ShuffleStrategy shuffleStrategy = new RandomShuffleStrategy();
        Deck deck = new Deck(shuffleStrategy);


        deck.shuffle();


        assert !deck.getCards().equals(deck) : "Deck should be shuffled.";

        System.out.println("testShuffleDeck passed.");
    }

    public void testDealCard() {
        ShuffleStrategy shuffleStrategy = new RandomShuffleStrategy();
        Deck deck = new Deck(shuffleStrategy);

        Card card = deck.dealCard();

        assert card != null : "Dealt card should not be null.";
        assert deck.size() == 51 : "Deck should have 51 cards after dealing one card.";

        deck.dealCard();
        deck.dealCard();
        deck.dealCard();

        assert deck.size() == 48 : "Deck should have 48 cards after dealing one card.";

        System.out.println("testDealCard passed.");
    }

    public void testDealAllCards() {
        ShuffleStrategy shuffleStrategy = new RandomShuffleStrategy();
        Deck deck = new Deck(shuffleStrategy);

        for (int i = 0; i < 52; i++) {
            deck.dealCard();
        }

        assert deck.size() == 0 : "Deck should be empty after dealing all 52 cards.";

        System.out.println("testDealAllCards passed.");
    }

    public void testDealCardFromEmptyDeck() {
        ShuffleStrategy shuffleStrategy = new RandomShuffleStrategy();
        Deck deck = new Deck(shuffleStrategy);

        for (int i = 0; i < 52; i++) {
            deck.dealCard();
        }

        try {
            deck.dealCard();
            assert false : "Expected EmptyDeckException but none was thrown.";
        } catch (EmptyDeckException e) {
            assert e.getMessage().equals("Cannot deal from an empty deck.") : "Expected EmptyDeckException with correct message.";
        }

        System.out.println("testDealCardFromEmptyDeck passed.");
    }
}
