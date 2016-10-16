package cards;

public class Player extends Hand {

    private final String name;
    private int points;
    private int noOfAce;

    public Player(String name) {
        this.name = name;
        points = 0;
        noOfAce = 0;
    }

    public String getName() {
        return name;
    }

    public void aceCounter() {
        noOfAce++;
    }

    public int getNoOfAce() {
        return noOfAce;
    }

    public int getPoints() {
        return points;
    }
    
    /*
    Adds up the value of the cards that player has on hand. Also changes value
    on some specific cards, for example Jacks, Queens, Kings, and Ace, because
    of the value that they have in this specific game
    */
    public void addPoints(int value) {
        if (value > 10) {
            value = 10;
        }
        if (value < 0) {
            value = 0;
        }
        if (value == 1) {
            value = 11;
            aceCounter();
        }
        points += value;

        while (points > 21 && getNoOfAce() > 0) {
            points -= 10;
            noOfAce--;
        }
    }
    
    /*
    Checks if player got busted (has a total value above 21)
    */
    public boolean busted() {
        return points > 21;
    }

    /*
    compares the hand of this particular player with another "player". In this
    game, this is used to compare this player's hand with the dealer's hand in
    order to find out if player won, lost, or ended up in a draw.
    */
    public String compareHands(Player other) {
        if (this.points > other.points && this.points <= 21) {
            return this.getName() + " Won!";
        } else if (this.points <= 21 && other.points > 21) {
            return this.getName() + " Won!";
        } else if (this.points == other.points && this.points <= 21) {
            return this.getName() + " got a Draw.";
        } else {
            return this.getName() + " Lost...";
        }
    }
}
