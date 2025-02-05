package casino;

import java.util.ArrayList;
import java.util.List;

/**
 * The Hand class represents a hand of cards in a game.
 * It extends the Deck class and includes methods for getting a hand,
 * setting a hand, and performing a hit action in the game.
 * 
 * @author Albert Rojas De Jesus
 * @version 1.0
 */
public class Hand extends Deck {
	
    /**
     * Constructs a new hand of cards.
     * 
     * @author Albert Rojas De Jesus
     * @version 1.0
     */
	public Hand(){
		super();
	}

    /**
     * Retrieves the current hand of cards.
     * 
     * @author Albert Rojas De Jesus
     * @return The list of cards in the hand.
     * @version 1.0
     */
	public List<String> getHand() {
		return hand;
	}

    /**
     * Sets the current hand of cards to the provided list.
     * 
     * @author Albert Rojas De Jesus
     * @param hand The list of cards to set as the hand.
     * @version 1.0
     */
	public void setHand(List<String> hand) {
		this.hand = hand;
	}
	
    /**
     * Performs a hit action, removing the first 
     * card from the provided list of cards.
     * 
     * @author Albert Rojas De Jesus
     * @param cards The list of cards to hit from.
     * @return The card that was removed from the list.
     * @version 1.0
     */
	public String hit(List<String> cards){
		String removedCard = new String();
		if(!cards.isEmpty()) {
			return removedCard = cards.remove(0);
		}
		return removedCard;
	}
	
	private List<String> hand = new ArrayList<>();
	
}// end of class Hand
