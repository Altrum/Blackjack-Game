package casino;

import java.util.ArrayList;
import java.util.List;

/**
 * The Dealer class represents a dealer 
 * in a casino, managing cards and gameplay.
 * It extends the Hand class and includes methods 
 * for dealing cards, hitting, and calculating hand values.
 * 
 * @author Albert Rojas De Jesus
 * @version 1.0
 * 
 */
public class Dealer extends Hand{
	
    /**
     * Retrieves the current hand of the dealer.
     * 
     * @author Albert Rojas De Jesus
     * @return The list of cards in the dealer's hand.
     * @version 1.0
     */
	public List<String> getDealersHand() {
		return dealersHand;
	}

    /**
     * Sets the dealer's hand to the provided list of cards.
     * 
     * @author Albert Rojas De Jesus
     * @param dealersHand The list of cards to set as the dealer's hand.
     * @version 1.0
     */
	public void setDealersHand(List<String> dealersHand) {
		this.dealersHand = dealersHand;
	}

    /**
     * Retrieves the current hand of the player.
     * 
     * @author Albert Rojas De Jesus
     * @return The list of cards in the player's hand.
     * @version 1.0
     */
	public List<String> getCardsPlayer() {
		return cardsPlayer;
	}

    /**
     * Sets the player's hand to the provided list of cards.
     * 
     * @author Albert Rojas De Jesus
     * @param cardsPlayer The list of cards to set as the player's hand.
     * @version 1.0
     */
	public void setCardsPlayer(List<String> cardsPlayer) {
		this.cardsPlayer = cardsPlayer;
	}
	
    /**
     * Deals a card from the provided list of cards.
     * 
     * @author Albert Rojas De Jesus
     * @param cards The list of cards to deal from.
     * @return The dealt card from the list.
     * @version 1.0
     */
	public String deal(List<String> cards) {
		if(!cards.isEmpty()) {
			return cards.remove(0);
		}
		return null;
	}
	
    /**
     * Deals a card to the dealer's hand from the provided list of cards.
     * 
     * @author Albert Rojas De Jesus
     * @param cards The list of cards to deal from.
     * @version 1.0
     */
	public void dealtoself(List<String> cards) {
		if(!cards.isEmpty()) {
			dealersHand.add(cards.remove(0));
		}
	}
	
	/**
	 * Retrieves a card from the list and returns the removed card.
	 *
	 * @param cards The list of cards to retrieve the hit from.
	 * @return The removed card.
	 * @version 1.0
	 */
	public String hit(List<String> cards){
		String removedCard = new String();
		if(!cards.isEmpty()) {
			return removedCard = cards.remove(0);
			
		}
		return removedCard;
	}

	/**
	 * Adds a card to the player's hand from the provided list of cards.
	 *
	 * @param cards The list of cards to add the hit from.
	 * @return The updated list of cards in the player's hand.
	 * @version 1.0
	 */
	public List<String> hitPlayer(List<String> cards) {
		if(!cards.isEmpty()) {
			this.cardsPlayer.add(hit(cards));
		}
		return this.cardsPlayer;
	}

	/**
	 * Prints the first card of the dealer while keeping the second one hidden.
	 * 
	 * @author Albert Rojas De Jesus
	 * @version 1.0
	 */
	public void printDealersHand() {
		System.out.println("Dealers hand " +
				getDealersHand().get(0) + 
				" and Card Face Down");
	}
	
	/**
	 * Prints the current value of the dealer's hand.
	 * 
	 * @author Albert Rojas De Jesus
	 * @version 1.0
	 */
	public void printDealersValue() {
		System.out.println("Dealer's values " +
				handValue(cardValues(getDealersHand())));
	}
	
	/**
	 * Prints the extra cards in the dealer's hand.
	 * 
	 * @author Albert Rojas De Jesus
	 * @version 1.0
	 */
	public void printDealersextraHand() {
		for(int i = 0; i < getDealersHand().size(); i++) {
			System.out.println("Dealer's Cards " +
					(i + 1) + ":" + " " +
					getDealersHand().get(i));
		}
	}
	
	/**
	 * Retrieves the value of the dealer's hand.
	 *
	 * @author Albert Rojas De Jesus
	 * @return The value of the dealer's hand.
	 * @version 1.0
	 */
	public int dealersHandValues() {
		int value = handValue(cardValues(getDealersHand()));
		return value;
	}
	
	/**
	 * Calculates the values of the cards 
	 * in the provided list and returns 
	 * them as a list of integers.
	 * it also Checks if card list has an 
	 * ACE and chooses the best case 
	 * scenario for the Dealer.
	 *
	 *@author Albert Rojas De Jesus
	 * @param cards The list of cards to calculate values for.
	 * @return The list of integer values representing the cards.
	 * @throws IllegalArgumentException if the provided list of cards is null.
	 */
	public List<Integer> cardValues(List<String> cards)throws IllegalArgumentException{
		if(cards == null) {
			throw new IllegalArgumentException("Cards list cannot be null");
		}
	    List<Integer> values = new ArrayList<>();
	    int currentSum = calculateSum(cards);

	    // Checks if card list has an ACE
	    boolean hasAce = false;
	    for(String card : cards) {
	        if(card.contains("Ace")) {
	            hasAce = true;
	            break;
	        }
	    }

	    if (hasAce) 
	    { // if there's an ACE choose 
	      //between 11 and 1 based on current sum
	        if (currentSum + 11 <= 21) {
	            for (String card2 : cards) {
	                String[] parts = card2.split(" ");
	                if (parts.length == 3) {
	                    String rank = parts[0];
	                    int value = getValue(rank, true);
	                    values.add(value);
	                }
	            }
	        } else {
	            for (String card2 : cards) {
	                String[] parts = card2.split(" ");
	                if (parts.length == 3) {
	                    String rank = parts[0];
	                    int value = getValue(rank, false);
	                    values.add(value);
	                }
	            }
	        }
	    } else { // otherwise false because there's no ACE
	        for (String card2 : cards) {
	            String[] parts = card2.split(" ");
	            if (parts.length == 3) {
	                String rank = parts[0];
	                int value = getValue(rank, false);
	                values.add(value);
	            }
	        }
	    }
	    return values;
	}

	/**
	 * Calculates the sum of the card 
	 * values in the provided list and returns the sum.
	 *
	 * @author Albert Rojas De Jesus
	 * @param cards The list of cards to 
	 * 			calculate the sum of values for.
	 * @return The sum of the values of the cards.
	 * @throws IllegalArgumentException if 
	 * 			the provided list of cards is null.
	 * @version 1.0
	 */
	public int calculateSum(List<String> cards)throws IllegalArgumentException {
		if(cards == null) {
			throw new IllegalArgumentException("Cards list cannot be null");
		}
	    int sum = 0;
	    for (String card : cards) {
	        String[] parts = card.split(" ");
	        if (parts.length == 3) {
	            String rank = parts[0];
	            sum += getValue(rank, false);
	        }
	    }
	    return sum;
	}// end of cardvalues
	
	/**
	 * Assigns values to the cards 
	 * based on their ranks and 
	 * whether the Ace is 
	 * 1 or 11.
	 *
	 *@author Albert Rojas De Jesus
	 * @param rank The rank of the 
	 * 			card for which the value is assigned.
	 * @param isAceHigh Determines whether 
	 * 		the Ace is considered true: 11 or false: 1.
	 * @return The assigned value for the card.
	 * @throws IllegalArgumentException if 
	 * 			the provided card rank is unknown.
	 * @version 1.0
	 */
	public int getValue(String rank, boolean isAceHigh)throws IllegalArgumentException 
	{// Switch statement will translate 
	 //the string values to integer values    
        switch (rank) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
            case "Jack":
            case "Queen":
            case "King":
                return 10;
            case "Ace":
                return isAceHigh ? 11 : 1; // if true: 11 false: 1
            default:
            	throw new IllegalArgumentException("Unknown card rank: " + rank);
        }
    }// end of getValue
	

	/**
	 * Calculates the total hand 
	 * value from the provided list of 
	 * numbers and returns the sum.
	 *
	 *@author Albert Rojas De Jesus
	 * @param numbers The list of integer
	 * 			values representing the cards.
	 * @return The sum of the hand values.
	 * @version 1.0
	 */
    public int handValue(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }// end of handValue
    
	private List<String> dealersHand = new ArrayList<>();
	private List<String> cardsPlayer = new ArrayList<>();
	
}// end of class Dealer
