package traders;

import card.Card;
import lib.ConsoleIO;
import player.Player;

public class Trade {
	
	private Player first;
	private Player second;
	private Card firstTrade;
	private Card secondTrade;
	
	public Trade(Player first, Player second)
	{
		this.first = first;
		this.second = second;
	}
	
	public void beginTrade()
	{
		boolean exit = false;
		do
		{
			exit = show();
			if(exit)
			{
				trade();
			}
			else
			{
				exit = ConsoleIO.promptForBool("Would you like to cancel the trade? ", "Yes", "No");
			}
		}while(!exit);
	}
	
	public void trade()
	{
		//We need a remove card method in deck to be able to remove the card
		first.getDeck().addCard(secondTrade);
		second.getDeck().addCard(firstTrade);
	}
	
	public boolean show()
	{
		//Getting the cards could potetially go inside the constructor
		
		String[] options = new String[first.getDeck().getDeck().size()];
		options = first.getDeck().getDeck().toArray(options);
		int input = ConsoleIO.promptForMenuSelection(options, false);
		firstTrade = first.getDeck().getDeck().get(input - 1);
		
		
		String[] options2 = new String[second.getDeck().getDeck().size()];
		options2 = second.getDeck().getDeck().toArray(options2);
		int input2 = ConsoleIO.promptForMenuSelection(options2, false);
		secondTrade = second.getDeck().getDeck().get(input2 - 1);
		
		
		//Then show the cards wanting to be traded
		boolean isGood = ConsoleIO.promptForBool("Player One, Do you accept this trade: ", "Yes", "No");
		boolean isAlsoGood = ConsoleIO.promptForBool("Player Two, Do you accept this trade: ", "Yes", "No");
		return isGood && isAlsoGood;
	}
}
