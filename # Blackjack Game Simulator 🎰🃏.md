README.md
# Blackjack Game Simulator 🎰🃏

## Project Overview
The **Blackjack Game Simulator** is a Java-based command-line application that emulates the popular 
casino card game, **Blackjack**. The game is designed for a single player against a dealer, following 
the standard rules of Blackjack, including betting, hitting, staying, and calculating hand values.

This project demonstrates **Object-Oriented Programming (OOP) principles**, utilizing a structured 
class hierarchy to model game components such as **Cards, Deck, Hand, Dealer, and Player**.

## Features ✅
- **Fully functional Blackjack game** with a betting system.
- **Object-Oriented Design** with modular class structures.
- **Dealer AI** follows standard Blackjack rules (hit/stay logic).
- **User Input Handling** allowing interactive gameplay.
- **Error Handling** for invalid inputs and edge cases.
- **Randomized Deck Shuffling** ensures fair gameplay.
- **Ace Handling Logic** allowing the dealer/player to switch between `1` or `11`.

## Project Structure 📂
The game follows a well-structured Java class design:

- **`Cards.java`** – Defines the card suits and ranks.
- **`Deck.java`** – Creates and shuffles a deck of 52 cards.
- **`Hand.java`** – Manages the cards held by players and the dealer.
- **`Dealer.java`** – Implements dealer logic, including hit/stay rules.
- **`Player.java`** – Handles player actions such as betting, hitting, and staying.
- **`BlackjackGameSimulator.java`** – The **main entry point** for the game, managing game flow and interactions.

## How to Run the Program 🚀
### Prerequisites
Ensure you have the following installed on your system:
- **Java Development Kit (JDK) 8+**
- **IDE** (such as IntelliJ, Eclipse, or NetBeans) or a terminal with Java setup.

### Running the Game
1. Clone or download the project repository.
2. Compile the Java files:
   ```sh
   javac casino/*.java
   ```
3. Run the main game simulator:
   ```sh
   java casino.BlackjackGameSimulator
   ```
4. Follow the on-screen prompts to play!

## Gameplay Instructions 🎮
1. The game begins by asking if you want to play.
2. The player starts with an initial balance and places a bet.
3. Two cards are dealt to the player and the dealer (one dealer card is hidden).
4. The player can choose to:
   - **Hit**: Receive an additional card.
   - **Stay**: Keep the current hand and let the dealer play.
5. If the player's total hand value exceeds **21**, they "bust" and lose the round.
6. The dealer follows a standard **Blackjack strategy**, hitting until reaching **17 or higher**.
7. The winner is determined based on the closest hand value to **21**.
8. The player can choose to play another round or exit.

## Key Concepts Used 💡
- **Encapsulation** – Each class has well-defined responsibilities.
- **Inheritance** – `Player` and `Dealer` classes extend `Hand` to share behavior.
- **Polymorphism** – Overridden methods for different game elements.
- **Exception Handling** – Ensures smooth execution and prevents crashes.

## Potential Enhancements 🔧
- **Graphical User Interface (GUI)** – Convert the text-based game into an interactive GUI.
- **Multiplayer Mode** – Allow multiple players to compete against the dealer.
- **Database Integration** – Store game history and betting records.
- **Advanced AI** – Implement different difficulty levels for the dealer.

## Author ✍️
**Albert Rojas De Jesus**  
📧 Contact: rojasdejesusa@outlook.com

---

Give this project a ⭐ on GitHub if you like it! Happy coding! 🎰🃏
