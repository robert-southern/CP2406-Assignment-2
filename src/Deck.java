
/*  - Object used to represent the playing deck.
    - Contains the cards in an array list and keeps track of the number of cards.
    - Has a shuffle method.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deckList = new ArrayList();


    public Deck() {

    }

    public void shuffleDeck() {

        // Attempt at Fisher-Yates shuffle algorithm

//        int i;
//        int n = deckList.size();
//
//        for (i = 0; i < (n - 1); i++) {
//
//            Random rand = new Random();
//
//            int j = rand.nextInt(n - 1) + i;
//
//            Card iIndex = deckList.remove(i);
//            Card jIndex = deckList.remove(j);
//
//            deckList.add(i, jIndex);
//            deckList.add(j, iIndex);
//
//        }

        Collections.shuffle(this.deckList);
    }


    public Card getNextCard() {

        return deckList.remove(0);
    }

    public void addCard(Card card) {

            deckList.add(card);
    }

    public int size() {

        return deckList.size();
    }

}
