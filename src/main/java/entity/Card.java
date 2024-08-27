package main.java.entity;

public record Card(Suit suit, FaveValue faveValue) {
    @Override
    public Suit suit() {
        return suit;
    }

    @Override
    public FaveValue faveValue() {
        return faveValue;
    }
}
