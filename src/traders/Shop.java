package traders;

import card.Card;
import lib.ConsoleIO;
import player.Player;

public class Shop {
	
	private Player player;
	
	public Shop(Player player)
	{
		this.player = player;
	}
	
	public void shop()
	{
		
	}
	
	public void buy(int credit, Card[] boosterPack)
	{
		if(player.getCredit() < credit)
		{ //player doesn't have enough money
			
		}
		else
		{ //player does have enough money
			player.setCredit(player.getCredit() - credit);
			for(int i = 0; i < boosterPack.length; i++)
			{
				player.getDeck().addCard(boosterPack[i]);
			}
		}
	}
	
	public void sell()
	{
		String[] options = new String[player.getDeck().getDeck().size()];
		options = player.getDeck().getDeck().toArray(options);
		int input = ConsoleIO.promptForMenuSelection(options, false);
		// adds the credit to the players money while also removing it from the deck
		player.setCredit(player.getCredit() + player.getDeck().pullCard(input - 1).cost);
		
	}
}
