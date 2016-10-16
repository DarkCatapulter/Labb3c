package cards;

public class Game {

    private final int noOfPlayers = 3; //can be changed to increase/decrease no of players
    private final Player[] player = new Player[noOfPlayers + 1]; //Creates array of players

    public void init() {
        GameUI ui = new GameUI();   //Creates Game UI object
        Deck deck = new Deck();        //Creates new deck with 52 playing cards
        deck.shuffleCards();           //Shuffles deck of cards

        /*
        Creates array of players and a dealer
        Assigns name to players and dealer
         */
        for (int i = 0; i < noOfPlayers; i++) {
            String name = "Player " + (i + 1);
            player[i] = new Player(name);
        }
        player[noOfPlayers] = new Player("Dealer");

        /*
        Deals two cards to each player,
        starting with player 1 and ending with dealer
         */
        /*for (int i = 0; i <= noOfPlayers; i++) {
            player[i].addCard(deck.dealCard());
            player[i].addCard(deck.dealCard());
        }*/

        /*
        Adds the total value of the cards players have currently in their hands
         */
        for (int i = 0; i <= noOfPlayers; i++) {
            for (int j = 0; j < player[i].getNoOfCards(); j++) {
                Card c = player[i].getCard(j);
                player[i].addPoints(c.getRankValue());
            }
        }
        /*
        Shows what cards each player currently have, including the dealer
         */
        for (int i = 0; i <= noOfPlayers; i++) {
               ui.showHand(player[i]);
          
        }

        /*
        Lets the players make their move (hit or stay) in numerical order,
        not including the dealer. Each player gets to play until they stay
        or until they bust (get a value above 21)
         */
        for (int i = 0; i < noOfPlayers; i++) {
            int stillMyTurn = 0;
            while (stillMyTurn == 1 || stillMyTurn == 0) {
                stillMyTurn = ui.playerMove(player[i]);
                if (stillMyTurn == 1) {
                    player[i].addCard(deck.dealCard());
                    Card c = player[i].getCard(player[i].getNoOfCards() - 1);
                    player[i].addPoints(c.getRankValue());
                    ui.showHit(player[i], c);
                }
                if (player[i].busted()) {
                    stillMyTurn = 2;
                    ui.printBusted(player[i]);
                }
            }
        }

        /*
        Dealer's turn to make their move (hit or stay). Dealer will unlike
        players automatically hit or stay until their total value equals
        18 or greater.
         */
        int stillMyTurn = 1;
        while (stillMyTurn == 1 || stillMyTurn == 0) {
            stillMyTurn = ui.dealerMove(player[noOfPlayers]);
            if (stillMyTurn == 1) {
                player[noOfPlayers].addCard(deck.dealCard());
                Card c = player[noOfPlayers].getCard(player[noOfPlayers].getNoOfCards() - 1);
                player[noOfPlayers].addPoints(c.getRankValue());
                ui.showHit(player[noOfPlayers], c);
            }
            if (player[noOfPlayers].busted()) {
                stillMyTurn = 2;
                ui.printBusted(player[noOfPlayers]);
            }
        }
        /*
        Calls the method that finds out and prints out the winners and losers
        */
        ui.winners(player, noOfPlayers);
    }
}
