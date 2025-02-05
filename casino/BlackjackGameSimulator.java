package casino;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The BlackjackGameSimulator class simulates 
 * a simple Blackjack game between a dealer and a player.
 * It allows players to bet cash, receive 
 * cards, and play rounds of the game until 
 * they run out of money.
 * 
 * @author Albert Rojas De Jesus
 * @version 1.0
 */
public class BlackjackGameSimulator {
	
    /**
     * The main method that runs 
     * the Blackjack game simulation.
     *
     * @author Albert Rojas De Jesus
     * @param args The command-line 
     * 			arguments passed to the program.
     * @version 1.0
     */
	public static void main(String [] args) {
		
		try {
			Dealer cards = new Dealer();
			Player player = new Player();
			Dealer dealer = new Dealer();
			List<String> deck = null;

			//START OF BLACKJACK GAME
			Scanner bet = new Scanner(System.in); // user input
			System.out.println("Do you want to play BlackJack?");
			String gameIsOn = bet.nextLine();
			boolean gameOn;
			if(gameIsOn.equals("yes")) {
				gameOn = true; //while gameOn is true game will run
			}
			else
			{
				gameOn = false;
			}
			
			boolean anotherRound = true;
			while((anotherRound) && (player.getBetCash() > 0)) {

				System.out.println("New Round!!!");
				deck = cards.deckOfCards();
				deck = cards.shuffleCards();
				player.setPlayersHand(new ArrayList<>());
				dealer.setDealersHand(new ArrayList<>());
				player.dealToPlayer(deck); // card one
				player.dealToPlayer(deck); // card two
				int turns = 0;
				
				
				System.out.println(
						"How much Money Would you like to bet: " 
								+ "Current Balance: " 
								+ "$"+player.getBetCash());

				double shipsreceived = bet.nextDouble();
				bet.nextLine();// Consume Line
				playAgain: while(gameOn) 
				{// playAgain is a placeholder an
				 //activates with a break statement
					turns++;
//				First turn Dealers deals to Player 
					if(turns == 1) 
					{// if first turn player receives two cards
						deck = cards.deckOfCards();
						deck = cards.shuffleCards();
						player.setPlayersHand(new ArrayList<>());
						dealer.setDealersHand(new ArrayList<>());
						player.dealToPlayer(deck); // card one
						player.dealToPlayer(deck); // card two
					}

					//prints player's hand
					player.printPlayersHand();
					player.printPlayersHandValue();//Player card values
				
					if(player.playersHandValues() == 21) {
						System.out.println("You have Won Do you want to play again? ");
						player.chickenDinner(shipsreceived);
						System.out.println("Do you want to play again? ");
						String keepGoing = bet.nextLine();
						if(keepGoing.equals("yes")) {
							anotherRound = true;
							break playAgain; // return to the beginning
						}
						else {
							System.exit(0);
						}
					}if(player.playersHandValues() < 21) 
					{//If player does not total 21 dealer gets 2 cards
						deck = cards.shuffleCards(); // shuffle cards for the dealer
						dealer.dealtoself(deck);
						dealer.dealtoself(deck);
						// Dealers cards one face up one face down.
						dealer.printDealersHand();// Shows the first hand of the Dealer

			
					}
					else if(player.playersHandValues() > 21) {
						System.out.println("BUST!!!!");
						player.setBetCashsubtract(shipsreceived);
						System.out.println("You are OUT! Do you want to play again? ");
						String keepGoing = bet.nextLine();
						if(keepGoing == "yes") {
							anotherRound = true;
							break playAgain; // return to the beginning
						}
						else {
							System.exit(0);
						}

					}
					gameOn = true;
					while(gameOn) {

						// Does the player want to stay or hit!
						System.out.println("hit or stay");
						String hit = bet.nextLine();

						if((hit.equals("hit"))) {
							deck = cards.shuffleCards(); // Dealer shuffle cards
							player.dealToPlayer(deck); // player receives more cards.
							player.printPlayersextraHand();
							System.out.println();
							player.printPlayersHandValue();//Player card values

							// Conditional statement to check for a winner or loser
							if(player.playersHandValues() == 21) {
								System.out.println("You have Won!!!!!");
								player.chickenDinner(shipsreceived);
								System.out.println("Do you want to play again? ");
								String keepGoing = bet.nextLine();
								if(keepGoing.equals("yes")) {
									anotherRound = true;
									break playAgain; // return to the beginning
								}
								else {
									anotherRound = false;
									System.exit(0);
								}
							}
							else if(player.playersHandValues() < 21)
							{
								System.out.println();
							}
							else if (player.playersHandValues() > 21){
								System.out.println("Player has BUST!!!!");
								player.setBetCashsubtract(shipsreceived); // Lost bet
								System.out.println("You are OUT! Do you want to play again? ");
								String keepGoing = bet.nextLine();
								if(keepGoing.equals("yes")) {
									anotherRound = true;
									break playAgain; // return to the beginning
								}
								else {
									anotherRound = false;
									System.exit(0);
								}
							}// end of inner if
							
						}// end of first if
						else 
						{//Dealers turn!
							
							if(dealer.dealersHandValues() == 21) {
								System.out.println("You have Lost, Dealer Wins");
								player.setBetCashsubtract(shipsreceived); // Lost bet
								System.out.println("You are OUT! Do you want to play again? ");
								String keepGoing = bet.nextLine();
								if(keepGoing.equals("yes")) {
									anotherRound = true;
									break playAgain; // return to the beginning
								}
								else {
									anotherRound = false;
									System.exit(0);
								}
							}
							else if (dealer.dealersHandValues() < 17) {
								while(dealer.dealersHandValues() < 17) {
									dealer.dealtoself(deck);
								}
								dealer.printDealersextraHand();
								dealer.printDealersValue();
								if(dealer.dealersHandValues() == 21) {
									System.out.println("You have Lost, Dealer Wins");
									player.setBetCashsubtract(shipsreceived); // Lost bet
									System.out.println("You are OUT! Do you want to play again? ");
									String keepGoing = bet.nextLine();
									if(keepGoing.equals("yes")) {
										anotherRound = true;
										break playAgain; // return to the beginning
									}
									else {
										anotherRound = false;
										System.exit(0);
									}
								}
								else if(dealer.dealersHandValues() > 21) {
									System.out.println("Dealer BUST!!!!");
									System.out.println("You have Won this round");
									//player wins twice original amount
									player.doublechickenDinner(shipsreceived); 
									System.out.println("You are OUT! Do you want to play again? ");
									String keepGoing = bet.nextLine();
									if(keepGoing.equals("yes")) {
										anotherRound = true;
										break playAgain; // return to the beginning
									}
									else {
										anotherRound = false;
										System.exit(0);
									}
								}
							}
							else if ((dealer.dealersHandValues() >= 17) &&
									(dealer.dealersHandValues() < 21)) {
								continue;
							}
							else if(dealer.dealersHandValues() > 21) {
								System.out.println("Dealer BUST!!!!");
								System.out.println("You have Won this round");
								//player wins twice original amount
								player.doublechickenDinner(shipsreceived); 
								System.out.println("Do you want to play again? ");
								String keepGoing = bet.nextLine();
								if(keepGoing.equals("yes")) {
									anotherRound = true;
									break playAgain; // return to the beginning
								}
								else {
									anotherRound = false;
									System.exit(0);
								}
							}
								
						}//end of first else
				
					}// end of while loop

				}// end of second while loop
			}// end of another Round loop
			if(player.getBetCash() <= 0) {
				System.out.println("You don't have any cash left.");
			}
		} 
		catch (IllegalArgumentException e) {
			System.out.println(
					"Invalid argument. " 
							+ e.getMessage());
			e.printStackTrace();
		} 
		catch (InputMismatchException e) {
			System.out.println(
					"Invalid input please enter a valid number.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("An unspected error. " 
					+ e.getMessage());
			e.printStackTrace();
		}
	}// end of main
}// end of class

