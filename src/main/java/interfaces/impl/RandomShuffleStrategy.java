package main.java.interfaces.impl;

import main.java.entity.Card;
import main.java.interfaces.ShuffleStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomShuffleStrategy implements ShuffleStrategy {

    @Override
    public void shuffle(List<Card> cards) {
        //Collections.shuffle(cards, new Random());
        Random random = new Random();
        for(int i = cards.size()-1; i>0; i--) {
            int j = random.nextInt(i+1);
            Collections.swap(cards, i, j);
        }
    }
}
