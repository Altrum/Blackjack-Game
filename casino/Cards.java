package casino;


import java.util.Random;

/**
 * This class is the parent class of 
 * the BlackJack program this class
 * will create cards by implementing suits
 * and rank.
 * 
 * @author Albert Rojas De Jesus
 * @version 1.0
 * 
 */
public class Cards {
	
	/**
	 * Constructor for class Card
	 * it creates suits and ranks arrays
	 * that will be used in the BlackJack game
	 * 
	 * @author Albert Rojas De Jesus
	 * @version 1.0
	 */
	public Cards() {
		this.setSuit(getSuits());
		this.setRank(getRanks());
	}
	/**
	 * Getter getSuit returns 
	 * the array suit
	 * 
	 * @author Albert Rojas De Jesus
	 * @return return the suit array
	 * @version 1.0
	 */
	public String[] getSuit() {
		return getSuits();
	}

	/**
	 * Setter setSuit returns the
	 * array suits
	 * 
	 * @author Albert Rojas De Jesus
	 * @param suit
	 * @version 1.0
	 */
	public void setSuit(String[] suit) {
		this.setSuits(suit);
	}

	/**
	 * Getter getRank returns 
	 * the array ranks
	 * 
	 * @author Albert Rojas De Jesus
	 * @return ranks
	 * @version 1.0
	 */
	public String[] getRank() {
		return getRanks();
	}

	/**
	 * Setter setRank returns
	 * the array rank
	 * 
	 * @author Albert Rojas De Jesus
	 * @param rank
	 * @version 1.0
	 */
	public void setRank(String[] rank) {
		this.setRanks(rank);
	}
	
	/**
	 * SeeCard method uses the suit 
	 * and the rank in other return a 
	 * string to the this string can be 
	 * printed into the output 
	 * for example 2 of Hearts.
	 * 
	 * @author Albert Rojas De Jesus
	 * @return String
	 * @throws IllegalArgumentException
	 * @version 1.0
	 */
	public String seeCard()throws IllegalArgumentException 
	{
		if((getSuit() == null) ||
				(getRanks() == null) || 
				(getSuits().length == 0) ||
				(getRanks().length == 0))
		{// if getters are null throw IllegalArgumentException
			throw new IllegalArgumentException("Suits or Ranks arrays cannot be empty");
		}
		Random random = new Random();
		
		int randomIndex = random.nextInt(getSuits().length);
		int randomIndexTwo = random.nextInt(getSuits().length);
		
		return getSuits()[randomIndex] + " " 
		+ getRanks()[randomIndexTwo];
	}// end of seeCard

	/**
	 * Getter getSuits returns
	 * the array suits
	 * 
	 * @author Albert Rojas De Jesus
	 * @return suits
	 * @version 1.0
	 */
	public String[] getSuits() {
		return suits;
	}
	
	/**
	 * Setter setSuits set
	 * the array suits for 
	 * the private varaible
	 * 
	 * @author Albert Rojas De Jesus
	 * @param suits array of strings
	 * @version 1.0
	 */
	public void setSuits(String[] suits) {
		this.suits = suits;
	}
	
	/**
	 * Getter getRanks gets
	 * the array Rank for 
	 * private variable
	 * 
	 * @author Albert Rojas De Jesus
	 * @return ranks array
	 * @version 1.0
	 */
	public String[] getRanks() {
		return ranks;
	}
	
	/**
	 * Setter setRanks sets
	 * the array ranks for
	 * the private variable
	 * 
	 * @author Albert Rojas De Jesus
	 * @return ranks array
	 * @version 1.0
	 */
	public void setRanks(String[] ranks) {
		this.ranks = ranks;
	}
	
	private String[] suits = {
			"Heart", "Diamond", 
			"Club", "Spades"};
	private String[] ranks = {
			"2","3","4","5","6",
			"7","8","9","10", "Jack", 
			"Queen", "King", "Ace"};

}// end Cards
