package card;

import java.io.Serializable;

import enums.CardRank;
import lib.ConsoleIO;
import player.Player;

@SuppressWarnings("serial")
public abstract class Card implements Serializable{

	public final String name;
	public final CardRank rank;
	public final int cost;
	public final int manaCost;
	public final int damage;
	public final int health;
	public final String description;
	
	public Card(String name, CardRank rank, int cost, int manaCost, int damage, int health, String description) {
		super();
		this.name = name;
		this.rank = rank;
		this.cost = cost;
		this.manaCost = manaCost;
		this.damage = damage;
		this.health = health;
		this.description = description;
	}
	
	public abstract void cardAbility(Player player);
	
	public static Card newCard(boolean admin) {
		Card c = null;
		if (admin) {
			boolean isSpell = ConsoleIO.promptForBool("Is this a Spell or Creature (s/c)", "s", "c");
			String name = ConsoleIO.promptForInput("Enter the card's name:", false);
			CardRank[] crArr = CardRank.values();
			String[] options = new String[crArr.length];
			int i = 0;
			for (CardRank cr : crArr) {
				options[i] = cr.toString();
				i++;
			}
			int rank = ConsoleIO.promptForMenuSelection(options, false);
			int cost = ConsoleIO.promptForInt("How much will this card cost in the store?", 0, Integer.MAX_VALUE);
			int manaCost = ConsoleIO.promptForInt("How much mana will this card cost?", 0, Integer.MAX_VALUE);
			int damage = ConsoleIO.promptForInt("How much damage will this card have?", 0, Integer.MAX_VALUE);
			int health = ConsoleIO.promptForInt("How much damage will this card have?", 0, Integer.MAX_VALUE);
			boolean done = false;
			String description = "";
			while (!done) {
				description = ConsoleIO.promptForInput("Enter the card's description:", true);
				done = ConsoleIO.promptForBool("Would you like to add another line? (y/n)", "n", "y");
			}
			if(isSpell) {
				c = new Spell(name, crArr[rank], cost, manaCost, damage, health, description);
			}else {
				c = new Creature(name, crArr[rank], cost, manaCost, damage, health, description);
			}

		} else {
			System.out.println("You're not supposed to be here.");
		}
		return c;
	}
}
