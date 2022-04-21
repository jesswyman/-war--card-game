/* name: Jess Wyman
 * date: 3.27.2020
 * description: the war class contains the code to actually play a game of War
 */

package cardGame;
import java.util.Scanner;
import java.io.*;

public class War {
	
	//initializes the scores as static variables
	static int playerScore = 0;
	static int computerScore = 0;
	
	public static void main(String[] args) {
		
		//initializes the scanner
		Scanner scan = new Scanner(System.in);
		
		//asks if the player wants to begin a game
		System.out.println("Would you like to play a game of War? Please enter 'y' or 'n'");
		
		//if player answers "y" game begins
		if(scan.nextLine().equals("y"))
		{
			//deck is initialized
			Deck deck = new Deck();
			
			//prompts enter key
			System.out.println("Please press enter to shuffle the deck.");
			promptEnterKey();
			
			//prints a visual cue and calls the shuffle method
			System.out.println("Shuffling deck...");
			deck.shuffle();
			
			//while deck isn't empty, the round method is called
			while(deck.isEmpty() == false)
			{
				round(deck); 
			}
			
			//prints that the game is over when the while loop breaks
			System.out.println("The game is over.");
			
			//prints the winner based on the final score
			if(playerScore > computerScore)
				System.out.println("You won the game, with " + playerScore + " cards!");
			else if(computerScore > playerScore)
				System.out.println("You lost the game, with only " + playerScore + " cards.");
			else
				System.out.println("The game ended in a stalemate.");
		}
		
		//prints "Alright" if player says they don't want to start a game
		else
		{
			System.out.println("Alright.");
		}
		
		//closes scanner
		scan.close(); 
	}
	
	//promptEnterKey class which was given to us
	public static void promptEnterKey(){
		try {
		System.in.read(new byte[2]);
		}
		catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	public static void round(Deck deck) {
		
		//prompts enter key
		System.out.println("Please press enter to draw cards.");
		promptEnterKey();
		
		//prints visual cue and draws two card, announcing the card drawn
		System.out.println("Drawing cards...");
		Card c1 = deck.draw();
		System.out.println("You drew: " + c1.getSuit() + c1.getRank());
		Card c2 = deck.draw();
		System.out.println("The computer drew: " + c2.getSuit() + c2.getRank());
		
		//checks who had the higher rank
		if(c1.getRank() > c2.getRank())
		{
			playerScore += 2;
			System.out.println("You won the round!");
			System.out.println("You have " + playerScore + " cards, and the computer has " + computerScore + " cards.");
		}
		else if(c2.getRank() > c1.getRank())
		{
			computerScore += 2;
			System.out.println("You lost the round.");
			System.out.println("You have " + playerScore + " cards, and the computer has " + computerScore + " cards.");
		}
		//if ranks are equal, player is informed a War is about to start and prompts the enter key
		else if(c1.getRank() == c2.getRank())
		{
			//checks if there are cards in the deck
			if(deck.isEmpty() == false)
			{
				System.out.println("Your ranks matched. You are about to enter a WAR. Please press ENTER");
				promptEnterKey();
				//calls war method
				war(deck);
			}
			//prints that the deck is empty and ends the round and game.
			else
				System.out.println("You're ranks matched, but the deck is empty.");
		}
	}
	
	public static void war(Deck deck) {
		
		//draws two cards
		Card p1 = deck.draw();
		Card c1 = deck.draw();
		
		//checks if there are cards in the deck again
		if(deck.isEmpty() == false)
		{
			//draws cards
			Card p2 = deck.draw();
			Card c2 = deck.draw();
			
			//prints ranks and suits of cards drawn
			System.out.println("You drew " + p1.getSuit() + p1.getRank() + " and " + p2.getSuit() + p2.getRank());
			System.out.println("The computer drew " + c1.getSuit() + c1.getRank() + " and " + c2.getSuit() + c2.getRank());
			
			//compares ranks of first cards
			if(p1.getRank() > c1.getRank())
			{
				System.out.println("You won the war!");
				playerScore += 6;
				System.out.println("You have " + playerScore + " cards, and the computer has " + computerScore + " cards.");

			}
			else if(p1.getRank() < c1.getRank())
			{
				System.out.println("You lost the war.");
				computerScore += 6;
				System.out.println("You have " + playerScore + " cards, and the computer has " + computerScore + " cards.");

			}
			//if ranks are the same, compares ranks of second cards
			else if(p1.getRank() == c1.getRank())
			{
				System.out.println("Your first card ranks matched. Checking second set of cards...");
				
				//compares ranks of second cards
				if(p2.getRank() > p2.getRank())
				{
					System.out.println("You won the war!");
					playerScore += 6;
					System.out.println("You have " + playerScore + " cards, and the computer has " + computerScore + " cards.");
				}
				else if(p2.getRank() < c2.getRank())
				{
					System.out.println("You lost the war.");
					computerScore += 6;
					System.out.println("You have " + playerScore + " cards, and the computer has " + computerScore + " cards.");
				}
				//ends the war at a stalemate if second set of cards also matched ranks
				else
				{
					System.out.println("The war ends at a stalemate.");
					playerScore += 3;
					computerScore += 3;
					System.out.println("You have " + playerScore + " cards, and the computer has " + computerScore + " cards.");
				}
			}
		}
		//ends the war if there aren't enough cards to draw again
		else
			System.out.println("There aren't enough cards to complete the war.");
	}
}
