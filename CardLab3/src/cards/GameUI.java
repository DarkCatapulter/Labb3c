package cards;

import java.util.Scanner;

public class GameUI {

    /*
    Shows the entire hand of intended player
     */
    public void showHand(Player p) throws NoSuchCardException {
        p.sortHand();
        System.out.print(p.getName() + " has ");
        Card c;
        if (p.getNoOfCards() == 0) {
            throw new NoSuchCardException(3);
        }
        for (int i = 0; i < p.getNoOfCards(); i++) {
            try {
                c = p.getCard(i);
                if (i != 0) {
                    System.out.print(" and ");
                }
                System.out.print(c);
            } catch (NoSuchCardException e) {
                throw e;
            }
        }
        System.out.println("\n");
    }

    /*
    Prints out the user interface to inform players of the different choices. 
    Depending on what move the player makes by scanning their input, it then
    runs the appropiate code
     */
    public int playerMove(Player p) {
        Scanner sc = new Scanner(System.in);
        System.out.println(p.getName() + ", do you hit or stay?");
        System.out.println("1 = hit, 2 = stay");
        int hitOrStay = sc.nextInt();
        switch (hitOrStay) {
            case 1:
                System.out.println("Dealer hits " + p.getName() + "\n");
                return 1;
            case 2:
                System.out.println(p.getName() + " choose to stay \n");
                return 2;
            default:
                System.out.println("That is not a valid option \n");
                return 0;
        }
    }

    public void printBusted(Player p) {
        System.out.println(p.getName() + " got busted \n");
    }

    /*
    Prints out the user interface when the dealer make his move,
    just like in playerMove(). Difference here is that the dealer automatically
    choose to hit or stay since dealer is supposed to be an AI
     */
    public int dealerMove(Player p) {
        System.out.println("It's the Dealers turn");
        int hitOrStay;
        if (p.getPoints() > 17) {
            hitOrStay = 2;
        } else {
            hitOrStay = 1;
        }
        switch (hitOrStay) {
            case 1:
                System.out.println("Dealer hits himself");
                return 1;
            case 2:
                System.out.println("Dealer choose to stay \n");
                return 2;
            default:
                System.out.println("Dealer got confused and choose to stay \n");
                return 2;
        }
    }

    /*
    Prints out the most recent card that got added/hit to players hand
     */
    public void showHit(Player p, Card c) {
        System.out.println(p.getName() + " got a " + c + "\n");
    }

    /*
    Prints out which players won and which players depending on final results
     */
    public void winners(Player[] p, int noOfPlayers) {
        showHand(p[noOfPlayers]);
        System.out.println("Dealer had a total of " + p[noOfPlayers].getPoints() + " points \n");
        for (int i = 0; i < noOfPlayers; i++) {
            showHand(p[i]);
            System.out.println(p[i].getName() + " had a total of " + p[i].getPoints() + " points");
            System.out.println(p[i].compareHands(p[noOfPlayers]) + "\n");
        }
    }
}
