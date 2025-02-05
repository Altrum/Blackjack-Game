package casino;

import java.util.ArrayList;
import java.util.List;

/**
 * The Player class represents 
 * a player in a casino game.
 * It extends the Dealer class 
 * and contains methods for 
 * dealing cards to the player,
 * managing the player's hand and bet cash, 
 * and performing various operations 
 * related to the player's gameplay.
 *
 * @author Albert Rojas De Jesus
 * @version 1.0
 */
public class Player extends Dealer{
	
	/**
	 * Adds cards to the player's 
	 * hand from the provided list of cards.
	 *
	 * @author Albert Rojas De Jesus
	 * @param cards The list of cards 
	 * 			to deal to the player.
	 * @version 1.0
	 */
	public void dealToPlayer(List<String> cards) {
		if(!cards.isEmpty()) {
			playersHand.add(cards.remove(0));
		}
	}// end of dealToPlayer

	/**
	 * Retrieves the list of cards in the player's hand.
	 *
	 * @author Albert Rojas De Jesus
	 * @return The list of cards in the player's hand.
	 * @version 1.0
	 */
	public List<String> getPlayersHand() {
		return playersHand;
	}// end of getPlayersHand

	/**
	 * Sets the player's hand with 
	 * the provided list of cards.
	 *
	 * @author Albert Rojas De Jesus
	 * @param playersHand The list of 
	 * 			cards to set as the player's hand.
	 * @version 1.0
	 */
	public void setPlayersHand(List<String> playersHand) {
		this.playersHand = playersHand;
	}// end of setPlayersHand

	/**
	 * Retrieves the current bet cash amount.
	 *
	 * @author Albert Rojas De Jesus
	 * @return The current bet cash amount.
	 * @version 1.0
	 */
	public double getBetCash() {
		return betCash;
	}// end of getBetCash

	/**
	 * Adds the provided bet 
	 * cash to the player's current bet.
	 *
	 * @author Albert Rojas De Jesus
	 * @param betCash The bet cash amount 
	 * 			to add to the current bet.
	 * @throws IllegalArgumentException if the 
	 * 			provided bet cash is not greater than 0.
	 * @version 1.0
	 */
	public void setBetCashadd(double betCash)throws IllegalArgumentException {
		if(betCash <= 0) {
			throw new IllegalArgumentException("Bet must be greater than 0");
		}
		this.betCash += betCash;
	}// end of setBetCashadd
	
	/**
	 * Subtracts the provided bet 
	 * cash from the player's current bet.
	 *
	 * @author Albert Rojas De Jesus
	 * @param betCash The bet cash amount 
	 * 			to subtract from the current bet.
	 * @throws IllegalArgumentException if 
	 * 			the provided bet cash is not greater than 0.
	 * @version 1.0
	 *
	 */
	public void setBetCashsubtract(double betCash)throws IllegalArgumentException {
		if(betCash <= 0) {
			throw new IllegalArgumentException("Bet must be greater than 0");
		}
		this.betCash -= betCash;
	}// end of setBetCashsubtract
	
	/**
	 * Prints the cards in the player's hand.
	 * 
	 * @author Albert Rojas De Jesus
	 * @version 1.0
	 */
	public void printPlayersHand(){
		String firstCard = getPlayersHand().get(0);
		String secondCards = getPlayersHand().get(1);
		System.out.println("Player's Hand Card 1: " +
				firstCard + " Card 2: " + secondCards);
	}// end of printPlayersHand
	
	/**
	 * Prints the extra cards in the player's hand.
	 * 
	 * @author Albert Rojas De Jesus
	 * @version 1.0
	 */
	public void printPlayersextraHand() {
		for(int i = 0; i < getPlayersHand().size(); i++) {
			System.out.print("Player's Cards " +
					(i + 1) + ":" + " " +
					getPlayersHand().get(i) + " ");
		}
		System.out.println();
	}// end of printPlayersextraHand
	
	/**
	 * Prints the value of the 
	 * cards in the player's hand.
	 * 
	 * @author Albert Rojas De Jesus
	 * @version 1.0
	 */
	public void printPlayersHandValue() {
		int value = handValue(cardValues(getPlayersHand()));
			System.out.println("Player's values " + value);
	}// end of printPlayersHandValue
	
	/**
	 * Calculates and returns the value of the player's hand.
	 *
	 * @author Albert Rojas De Jesus
	 * @return The value of the player's hand.
	 * @version 1.0
	 */
	public int playersHandValues() {
		int value = handValue(cardValues(getPlayersHand()));
		return value;
	}// end of playersHandValues
	
	/**
	 * Calculates the values of the cards 
	 * in the provided list and returns 
	 * them as a list of integers.
	 * it also Checks if card list has an 
	 * ACE and chooses the best case scenario 
	 * for the Dealer.
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

	    if (hasAce) { // if there's an ACE choose
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
	}// end of method playersHandValues

	/**
	 * Calculates the sum of the card 
	 * values in the provided list and 
	 * returns the sum.
	 *
	 * @author Albert Rojas De Jesus
	 * @param cards The list of cards to calculate the sum of values for.
	 * @return The sum of the values of the cards.
	 * @throws IllegalArgumentException if the provided list of cards is null.
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
	}// end of calculateSum
	
	/**
	 * Assigns values to the cards based 
	 * on their ranks and whether the Ace is 
	 * 1 or 11.
	 *
	 * @author Albert Rojas De Jesus
	 * @param String rank The rank of the 
	 * 			card for which the value is assigned.
	 * @param isAceHigh Determines whether the Ace 
	 * 			is considered true: 11 or false: 1.
	 * @return The assigned value for the card.
	 * @throws IllegalArgumentException 
	 * 			if the provided card rank is unknown.
	 * @version 1.0
	 */
	// Get value assigns values to the cards and lets you choose your ACE
	public int getValue(String rank, boolean isAceHigh)throws IllegalArgumentException {
        // Add your logic here to assign values based on the rank
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
                return isAceHigh ? 11 : 1; // Or 1 depending
            default:
            	throw new IllegalArgumentException("Unknown card rank: " + rank);
        }
    }// end of getValue
	

	
	/**
	 * Calculates the total hand value 
	 * from the provided list of numbers 
	 * and returns the sum.
	 *
	 * @author Albert Rojas De Jesus
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
    
    /**
     * Increases the player's bet cash by 
     * 1.5 times the provided bet cash.
     *
     * @author Albert Rojas De Jesus
     * @param betCash The bet cash to use for 
     * 			calculating the increased amount.
     * @version 1.0
     */
    public void chickenDinner(double betCash) {
    	double winnerWinner = 1.5 * betCash;
    	this.betCash += winnerWinner;
    }// end of chickenDinner

    /**
     * Increases the player's bet cash 
     * by 2 times the provided bet cash.
     *
     * @author Albert Rojas De Jesus
     * @param betCash The bet cash to use for 
     * 			calculating the doubled amount.
     * @version 1.0
     */
    public void doublechickenDinner(double betCash) {
    	double winnerWinner = 2 * betCash;
    	this.betCash += winnerWinner;
    }// end of doublechickenDinner
    
	private List<String> playersHand = new ArrayList<>();
	private double betCash = 100;
    
}// end of Player
