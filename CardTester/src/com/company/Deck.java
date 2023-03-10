package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Deck extends Card{
    //Variables
        Card[] deck = new Card[52];
        private int remainingCards;
        private Card currentCard = new Card();
    //Default constructor fills deck array
    public Deck() {
        int i = 0;
        for(Name n : Name.values()) {
            for (Suit s : Suit.values()) {
                deck[i] = new Card(n , s);
                i++;
            }
        }
        currentCard = deck[0];
    }

//Getters
    public Card[] getDeck() {
        return deck;
    }

    public int getRemainingCards() {
        return remainingCards;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    //Setters
    public void setDeck(Card[] deck) {
        this.deck = deck;
    }

    public void setRemainingCards(int remainingCards) {
        this.remainingCards = remainingCards;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    //Shuffles the deck in a randomized order
    public void shuffle() {
        Random rand = new Random();

        for (int i = 0; i < deck.length; i++) {
            int random = rand.nextInt(deck.length);
            Card temp = deck[random];
            deck[random] = deck[i];
            deck[i] = temp;
        }
        currentCard = deck[0];
    }
    //Returns true if another card is available in the deck. False if at the end of the deck.
    public boolean hasNext(Card card) {
        boolean isNext = false;
        for (int i = 0; i < deck.length; i++) {
            if (card.equals(deck[i]) && i != 51) {
                isNext = true;
            }
        }
        return isNext;
    }
    //Returns the next card in the deck
    public Card next(int card) {
        int currCard = card;
        return deck[currCard + 1];
    }
    //Searches the array for the same card as the parameter.
    public boolean hasCard(Card card) {
        boolean isThere = false;
        for (int i = 0; i < deck.length; i++) {
            if (card.equals(deck[i])) {
                isThere = true;
            }
        }
        return isThere;
    }
    //To string method that prints the whole deck array.
    public String toString() {
        String cards = "";
        for (int i = 0; i < deck.length; i++) {
            cards += deck[i] + "\n";
        }
        return cards;
    }


}
