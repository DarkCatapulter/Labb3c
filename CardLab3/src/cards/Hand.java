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

    public Card getCard(int index) {
        try {
            return hand.get(index);
        } catch (NoSuchCardException n) {
                System.out.println(n.getMessage());
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
