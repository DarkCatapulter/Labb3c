
package cards;

/**
 *
 * @author Fatih Yalcin & Hampus Glantz
 */
public class NoSuchCardException extends java.lang.RuntimeException {
    /**
     * Gets specific exception value that later gets used by getMessage function
     */
    int whyYouBroken;
    
    public NoSuchCardException(int brokenShit) {
        whyYouBroken = brokenShit;
    }

    /**
     * Gets the message for specific exception
     * @return message
     */
    @Override
    public String getMessage() {
        switch (whyYouBroken) {
            case 1:
                return "Hand is out of boundaries ¯\\_(ツ)_/¯";
            case 2:
                return "Your deck ran out of cards dumbo";
            case 3:
                return "Your hand is broken, how did you even manage that?";
            default:
                return "You messed up so bad not even we know what you did";
        }
    }
}
