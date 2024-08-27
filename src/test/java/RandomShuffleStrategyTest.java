package test.java;

import main.java.entity.Card;
import main.java.entity.Deck;
import main.java.interfaces.ShuffleStrategy;
import main.java.interfaces.impl.RandomShuffleStrategy;

import java.util.List;

public class RandomShuffleStrategyTest {

    public static void main(String[] args) {
        RandomShuffleStrategyTest test = new RandomShuffleStrategyTest();
        test.testShuffle();
    }

    public void testShuffle() {
        ShuffleStrategy shuffleStrategy = new RandomShuffleStrategy();
        Deck deck = new Deck(shuffleStrategy);

        List<Card> cardsBeforeShuffle = List.copyOf(deck.getCards());
        shuffleStrategy.shuffle(deck.getCards());
        List<Card> cardsAfterShuffle = deck.getCards();

        assert !cardsBeforeShuffle.equals(cardsAfterShuffle) : "Cards should be shuffled and different from the original order.";

        System.out.println("testShuffle passed.");
    }
}
