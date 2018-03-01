package card;

import java.io.Serializable;

import enums.CardRank;
import lib.ConsoleIO;
import player.Player;

@SuppressWarnings("serial")
public abstract class Card implements Serializable {

	public final String name;
	public final CardRank rank;
	public final int cost;
	public final int manaCost;
	public final int power;
	public final String description;

	public Card(String name, CardRank rank, int cost, int manaCost, int power, String description) {
		super();
		this.name = name;
		this.rank = rank;
		this.cost = cost;
		this.manaCost = manaCost;
		this.power = power;
		this.description = description;
	}

	public abstract void cardAbility(Player player);

	public static Card newCard() {
		Card c = null;
		boolean isSpell = ConsoleIO.promptForBool("Is this a Spell or Creature (s/c)", "s", "c");
		String name = ConsoleIO.promptForInput("Enter the card's name:", false);
		CardRank[] crArr = CardRank.values();
		String[] options = new String[crArr.length];
		int i = 0;
		for (CardRank cr : crArr) {
			options[i] = cr.toString();
			i++;
		}
		int rank = ConsoleIO.promptForMenuSelection(options, false) - 1;
		int cost = ConsoleIO.promptForInt("How much will this card cost in the store?", 0, Integer.MAX_VALUE);
		int manaCost = ConsoleIO.promptForInt("How much mana will this card cost?", 0, Integer.MAX_VALUE);
		boolean done = false;
		String description = "";
		while (!done) {
			description = ConsoleIO.promptForInput("Enter the card's description:", true);
			done = ConsoleIO.promptForBool("Would you like to add another line? (y/n)", "n", "y");
		}
		int power = ConsoleIO.promptForInt("How much damage will this card have?", 0, Integer.MAX_VALUE);
		if (isSpell) {
			c = new Spell(name, crArr[rank], cost, manaCost, power, description);
		} else {
			int health = ConsoleIO.promptForInt("How much health will this card have?", 0, Integer.MAX_VALUE);
			int sleep = ConsoleIO.promptForInt("How long will this card sleep before playing?", 0, Integer.MAX_VALUE);
			c = new Creature(name, crArr[rank], cost, manaCost, power, health, sleep, description);
		}
		return c;
	}
	
	
	
}
