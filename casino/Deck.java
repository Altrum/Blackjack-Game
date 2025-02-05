package casino;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * The Deck class represents a deck of cards.
 * It extends the Cards class and includes 
 * methods for creating a deck of cards,
 * shuffling the deck, and displaying 
 * the remaining cards in the deck.
 * 
 * @author Albert Rojas De Jesus
 * @version 1.0
 */
public class Deck extends Cards {
	
	/**
     * Constructs a new deck of cards.
     * 
     * @author Albert Rojas De Jesus
     * @version 1.0
     */
	public Deck() {
		super();
		this.cardDeck = cardDeck;
	}		
	
    /**
     * Retrieves the current deck of cards.
     * 
     * @author Albert Rojas De Jesus
     * @return The list of cards in the deck.
     * @version 1.0
     */
	public List<String> getCardDeck(){
		return cardDeck;
	}
	
    /**
     * Sets the current deck of cards to the provided list.
     * 
     * @author Albert Rojas De Jesus
     * @param cardDeck The list of cards to set as the deck.
     * @version 1.0
     */
	public void setCardDeck(List<String> cardDeck) {
		this.cardDeck = cardDeck;
	}
	
    /**
     * Creates a new deck of cards by combining suits and ranks.
     * 
     * @author Albert Rojas De Jesus
     * @return The list of cards in the newly created deck.
     * @throws IllegalArgumentException if suits or ranks are null.
     * @version 1.0
     */
	public List<String> deckOfCards()throws IllegalArgumentException{
		if((getSuits() == null) || (getRanks() == null)) {
			throw new IllegalArgumentException("Suits and Ranks cannot be null");
		}
		for(String suit : getSuits()) {
			for(String rank : getRanks()) {
				cardDeck.add(rank + " of " + suit);
			}
		}
		return cardDeck;
	}

    /**
     * Shuffles the current deck of cards randomly.
     * 
     * @author Albert Rojas De Jesus
     * @return The shuffled list of cards.
     * @throws IllegalArgumentException if the card deck is null or empty.
     */
	public List<String> shuffleCards()throws IllegalArgumentException{
		if((cardDeck == null) || (cardDeck.isEmpty())) {
			throw new IllegalArgumentException("Card Deck cannot be null or empty");
		}
		Random random = new Random();
		
		for(int i = cardDeck.size() - 1 ; i > 0 ; i--) {
			int j  = random.nextInt(i + 1);
			String shift = cardDeck.get(i);
			cardDeck.set(i, cardDeck.get(j));
			cardDeck.set(j, shift);
		
		}
		return cardDeck;
	}// end of shuffleCards

    /**
     * Displays the remaining cards in the deck.
     * 
     * @author Albert Rojas De Jesus
     * @version 1.0
     */

	public void cardsLeft() {
		for(String card: cardDeck) {
			System.out.println(card);
		}
	}
	
	private List<String> cardDeck = new ArrayList<>();
	
}// end of class Deck
