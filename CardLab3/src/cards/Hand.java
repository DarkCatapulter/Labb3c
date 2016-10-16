package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {

    private final ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public int getNoOfCards() {
        return hand.size();
    }

    public void addCard(Card c) {
        hand.add(c);
    }

    public Card getCard(int index) throws NoSuchCardException {

        try {
            return hand.get(index);
        } catch (Exception n) {
            throw new NoSuchCardException(1);
        }
    }

    public Card removeCard(int index) {
        if (index >= 0 && index < hand.size()) {
            Card c = hand.get(index);
            hand.remove(index);
            return c;
        } else {
            return null;
        }
    }

    public void sortHand() {
        Collections.sort(hand, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                Integer obj1 = c1.getRankValue();
                Integer obj2 = c2.getRankValue();
                return obj1.compareTo(obj2);
            }
        });
    }
}
