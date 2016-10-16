package cards;

import java.util.Collections;
import java.util.ArrayList;

/**
 *
 * @author Faddy
 */
public class Deck {

    private final ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        fill();
    }

    public int getNoOfCards() {
        return deck.size();
    }

    public Card dealCard() {
        Card topCard = deck.get(0);
        deck.remove(0);
        return topCard;
    }

    public void shuffleCards() {
        Collections.shuffle(deck);
    }

    public void fill() {
        deck.clear();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Card e = new Card(r, s);
                deck.add(e);
            }
        }
    }

    @Override
    public String toString() {
        Card tempCard;
        String deckInfo = "";
        for (int i = 0; i < deck.size(); i++) {
            tempCard = deck.get(i);
            deckInfo = deckInfo + tempCard.toString() + "\n";
        }
        return deckInfo;
    }
}
