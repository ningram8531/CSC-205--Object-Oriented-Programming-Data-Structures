package com.company;

/**
 * @author Nick Ingram
 * title: Card
 * Desc: employes various methods to enable the user to play a card game and interact with card objects.
 */
public class Card {
    Name name;
    Suit suit;

//Default constructor
    public Card() {

    }
//Constructor with input
    public Card(Name name, Suit suit) {
        this.name = name;
        this.suit = suit;
    }

    public void setFace(Name name) {
        this.name = name;;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Name getName() {
        return this.name;
    }

    public Suit getSuit() {
        return this.suit;
    }
//Compares string to any value from both enums, returns true or false
    public boolean equals(Card other) {
        boolean equals = false;
        if (this.name == other.name && this.suit == other.suit) {
            equals = true;
        }
        return equals;
    }

    public int compareTo(Card other){
        int compare = -2;
        if (this.name.ordinal() > other.name.ordinal()) {
            compare = -1;
        }
            else if (this.name.ordinal() < other.name.ordinal()){
            compare = 1;
        }
            else {
             compare = 0;
        }

        return compare;
    }
//Converts a value from both enums to a string
        public String toString(Name face , Suit suit) {

        return (face) +
                " of " + suit;
    }

    public void displayCard() {
        System.out.println(name + " of " + suit);
    }

}
