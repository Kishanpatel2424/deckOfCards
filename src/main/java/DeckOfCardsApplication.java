package main.java;

import main.java.entity.Card;
import main.java.entity.Deck;
import main.java.interfaces.ShuffleStrategy;
import main.java.interfaces.impl.RandomShuffleStrategy;
import main.java.Exception.EmptyDeckException;


public class DeckOfCardsApplication {
    public static void main(String[] args) {

        ShuffleStrategy shuffleStrategy = new RandomShuffleStrategy();


        Deck deck = new Deck(shuffleStrategy);
        System.out.println("New Deck: "+ deck);

        deck.shuffle();
        System.out.println("Shuffle Deck: "+ deck);

        try {
            for (int i = 0; i < 53; i++) {
                Card card = deck.dealCard();
                System.out.println("Dealt: " + card+" Dealted Cards: "+i);
            }
        } catch (EmptyDeckException e) {
            System.err.println("Error: " + e.getMessage());
        }


        System.out.println("Remaining Cards: "+ deck.size());
    }
}