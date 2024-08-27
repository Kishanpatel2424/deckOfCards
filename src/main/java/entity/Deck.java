package main.java.entity;

import main.java.Exception.EmptyDeckException;
import main.java.interfaces.ShuffleStrategy;

import java.util.ArrayList;
import java.util.List;


public class Deck {
    private final List<Card> cards;
    private final ShuffleStrategy shuffleStrategy;

    public Deck(ShuffleStrategy shuffleStrategy) {
        this.shuffleStrategy = shuffleStrategy;
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (FaveValue faveValue : FaveValue.values()) {
                cards.add(new Card(suit, faveValue));
            }
        }
    }

    public void shuffle() {
        shuffleStrategy.shuffle(cards);
    }

    public Card dealCard() {
        if (!isEmpty()) {
            return cards.remove(0);
        } else {
            throw new EmptyDeckException("Cannot deal from an empty deck.");
        }
    }

    public int size() {
        return cards.size();
    }
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public List<Card> getCards() {
        return cards;
    }

}
