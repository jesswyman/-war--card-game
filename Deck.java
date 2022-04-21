/* name: Jess Wyman
 * date: 3.27.2020
 * description: This class holds all the methods for the card deck that the game will be played with
 */

package cardGame;

import java.util.Random;

public class Deck {
	private Card[] deck = new Card[52];
	private int top;
	
	public Deck()
	{
		//initializes suit and count
		char suit;
		int count = 0;
		
		//for loop runs 4 times - once for each suit
		for(int suitNum = 1; suitNum < 5; suitNum++)
		{
			//if statements assign suit
			if(suitNum == 1)
				suit = 'C';
			else if(suitNum == 2)
				suit = 'D';
			else if (suitNum == 3)
				suit = 'S';
			else
				suit = 'H';
			
			//for loop runs through cards rank 2-15 to add a card to the deck with suit and rank
			for (int rankNum = 2; rankNum < 15; rankNum++)
			{
				deck[count] = new Card(rankNum, suit);
				count++;
			}
		}
		
		//sets the top to 0 because the top card will have an index of 0 in the deck
		top = 0;
	}
	
	public void shuffle()
	{
		//for loop runs through each card in the deck and chooses a random card to swap it with
		for(int count = 0; count < 52; count++)
		{
			//gets a random integer and calls the swap function on the current card and the random card indexes
			Random randomNumbers = new Random();
			int random = randomNumbers.nextInt(52);
			swap(count, random);
		}
	}
	
	public Card draw()
	{
		//assigns an variable to the current top number, increases top, and then returns the card at index num
		int num = top;
		top++;
		return deck[num];
	}
	
	public boolean isEmpty()
	{
		//checks if top has reached the end of the deck array by determining if top has reached 50
		if(top > 50)
			return true;
		else
			return false;
	}
	
	private void swap(int i, int j)
	{
		//private method that takes in two card positions, and swaps the cards in those positions
		Card num1 = deck[i];
		Card num2 = deck[j];
		deck[i] = num2;
		deck[j] = num1;
	}
	
}