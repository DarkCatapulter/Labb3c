/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

/**
 *
 * @author Faddy
 */
public class NoSuchCardException extends java.lang.RuntimeException {

    int whyYouBroken;

    public NoSuchCardException(int brokenShit) {
        whyYouBroken = brokenShit;
    }

    @Override
    public String getMessage() {
        switch (whyYouBroken) {
            case 1:
                return "Out of boundaries";
            case 2:
                return "Your deck ran out of cards dumbo";
            case 3:
                return "Your hand is broken, how did you even manage that?";
            default:
                return "You messed up so bad not even we know what you did";
        }
    }
}
