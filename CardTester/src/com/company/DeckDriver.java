package com.company;

import java.util.Scanner;

/**
 * @author Nick Ingram
 * Title: Deck Tester
 * Desc: Ensures the card class deck class(extends card) works correctly by calling its methods.
 * The card tester code is commented out below main.
 */

import com.company.Deck;
import com.company.Card;
import com.company.Suit;
import com.company.Name;

public class DeckDriver {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        //Creating deck object which imports our array
        Deck deck1 = new Deck();
        //Variables
        int testCases = 0,  inBetween = 0, notInBetween = 0, matchesCard = 0;
        //Shuffling the deck x3
        for (int i = 0; i < 3; i++) {
            deck1.shuffle();
        }
        //Draw a card
        Card card1 = deck1.getCurrentCard();
        //Draw a 2nd card
        Card card2 = deck1.next(1);

        //If card1 equals card 2, increment test case and draw a 3rd card
        if (!card1.equals(card2)) {
            Card card3 = deck1.next(2);
            testCases++;
                //card 3 is in between card 1 and card 2, increment in between and test case
                if (((card3.compareTo(card1) > 0) && (card3.compareTo(card2) < 0)) ||
                        ((card3.compareTo(card1) < 0) && (card3.compareTo(card2) > 0))) {
                    inBetween++;
                    testCases++;
                } else if ((card3.compareTo(card1) == 0) || card3.compareTo(card2) == 0) {
                    //if either card1 or card 2 is equal to card 3, increment matches card and test case.
                    matchesCard++;
                    testCases++;
                } else { //if cards
                    notInBetween++;
                    testCases++;
                }
        }

        System.out.println("Displaying statistics: \n" + "Test Cases: " + testCases + "\n"
                + "In Between: " + inBetween + "\n" + "Not in Between: " + notInBetween + "\n"
                + "Matches Card: " + matchesCard);


    }
}
//    Scanner scnr = new Scanner(System.in);
//
//    Name name = Name.ACE;
//    Suit suit = Suit.SPADES;
//
//    Card aCard = new Card();
////Nested for loops to display all card combinations
//        for(Name f : Name.values()) {
//                for (Suit s : Suit.values()) {
//                System.out.println(f + ", " + s);
//                }
//                }
//                Card c1 = new Card(Name.THREE, Suit.SPADES);
//                Card c2 = new Card(Name.FOUR, Suit.DIAMONDS);
//
//                Name face1 = Name.EIGHT;
//                Name face2 = Name.TEN;
//
//                System.out.println(face1.compareTo(face2));
//                c2.displayCard();