package card;

import java.io.Serializable;

import enums.CardRank;
import enums.PowerID;
import lib.ConsoleIO;
import lib.Tool;

public abstract class Card implements Serializable {

	private static final long serialVersionUID = 8241558901048926297L;
	public final String name;
	public final CardRank rank;
	private int cost;

	public final int manaCost;
	private int power;
	public final PowerID powerID;
	public final String description;

	public Card(String name, CardRank rank, int cost, int manaCost, int power, PowerID powerID, String description) {
		super();
		this.name = name;
		this.rank = rank;
		this.cost = cost;
		this.manaCost = manaCost;
		this.power = power;
		this.description = description;
		this.powerID = powerID;
	}

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
		String[] powerIds = Tool.toStrArr(PowerID.values());
		PowerID powerID = PowerID.values()[ConsoleIO.promptForMenuSelection(powerIds, false)];
		if (isSpell) {
			c = new Spell(name, crArr[rank], cost, manaCost, power, powerID, description);
		} else {
			int health = ConsoleIO.promptForInt("How much health will this card have?", 0, Integer.MAX_VALUE);
			boolean sleep = ConsoleIO.promptForBool("Will this card sleep before attack?", "y", "n");
			c = new Creature(name, crArr[rank], cost, manaCost, power, powerID, health, sleep, description);
		}
		return c;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if(power>=0) {
			this.power = power;			
		}else {
			this.power = 0;
		}
	}
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	

}
