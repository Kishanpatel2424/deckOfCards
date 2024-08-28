package main.java;

import main.java.entity.Card;
import main.java.entity.Deck;
import main.java.interfaces.ShuffleStrategy;
import main.java.interfaces.impl.RandomShuffleStrategy;
import main.java.Exception.EmptyDeckException;

import java.util.Scanner;

public class DeckOfCardsApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShuffleStrategy shuffleStrategy = new RandomShuffleStrategy();
        Deck deck = null;
        boolean running = true;

        while (running) {
            System.out.println("Enter a command (start, deal, restart, quit):");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "start":
                    if (deck == null) {
                        deck = new Deck(shuffleStrategy);
                        deck.shuffle();
                        System.out.println("New game started! Deck initialized.");
                    } else {
                        System.out.println("Game already started. Use 'deal' to deal cards or 'restart' to start a new game.");
                    }
                    break;

                case "deal":
                    if (deck == null) {
                        System.out.println("Please start a game first with the 'start' command.");
                    } else {
                        try {
                            Card card = deck.dealCard();
                            System.out.println("Dealt: " + card);
                        } catch (EmptyDeckException e) {
                            System.out.println("No more cards to deal. The deck is empty.");
                            System.err.println("Error: " + e.getMessage());
                        }
                    }
                    break;

                case "restart":
                    deck = new Deck(shuffleStrategy);
                    deck.shuffle();
                    System.out.println("Game restarted! Deck reshuffled.");
                    break;

                case "quit":
                    running = false;
                    System.out.println("Exiting game. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid command. Please use 'start', 'deal', 'restart', or 'quit'.");
                    break;
            }
        }

        scanner.close();
    }
}
