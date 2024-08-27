package main.java.interfaces;

import main.java.entity.Card;

import java.util.List;

public interface ShuffleStrategy {
    void shuffle(List<Card> cards);
}
