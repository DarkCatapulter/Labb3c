package cards;

import java.util.ArrayList;

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

    public Card getCard(int index) throws NoSuchCardException{
        try {
            return hand.get(index);
        } catch (Exception n) {
                    if (index < 0 || index >hand.size()) {
                    throw new NoSuchCardException(1);
                } else if (hand.size() == 0) {
                    throw new NoSuchCardException(3);
                }
        }
        return null;
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
}
