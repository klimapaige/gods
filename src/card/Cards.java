package card;

import java.io.IOException;

import enums.CardRank;
import enums.PowerID;
import lib.ConsoleIO;
import lib.Tool;

public class Cards {

	public static Card newCard() {
		Card c = null;
		boolean isSpell = ConsoleIO.promptForBool("Is this a Spell or Creature (s/c) ", "s", "c");
		String name = ConsoleIO.promptForInput("Enter the card's name: ", false);
		CardRank[] crArr = CardRank.values();
		String[] options = new String[crArr.length];
		int i = 0;
		for (CardRank cr : crArr) {
			options[i] = cr.toString();
			i++;
		}
		int rank = ConsoleIO.promptForMenuSelection(options, false) - 1;
		int cost = ConsoleIO.promptForInt("How much will this card cost in the store? ", 0, Integer.MAX_VALUE);
		int manaCost = ConsoleIO.promptForInt("How much mana will this card cost? ", 0, Integer.MAX_VALUE);
		boolean done = false;
		String description = "";
		int power = ConsoleIO.promptForInt("How much damage will this card have? ", 0, Integer.MAX_VALUE);
		String[] powerIds = Tool.toStrArr(PowerID.values());
		PowerID powerID = PowerID.values()[ConsoleIO.promptForMenuSelection(powerIds, false) - 1];
		while (!done) {
			description += ConsoleIO.promptForInput("Enter the card's description: ", true);
			done = ConsoleIO.promptForBool("Would you like to add another line? (y/n) ", "n", "y");
		}
		if (isSpell) {
			c = new Spell(name, crArr[rank], cost, manaCost, power, powerID, description);
		} else {
			int health = ConsoleIO.promptForInt("How much health will this card have? ", 0, Integer.MAX_VALUE);
			boolean sleep = ConsoleIO.promptForBool("Will this card sleep before attack? ", "y", "n");
			c = new Creature(name, crArr[rank], cost, manaCost, power, powerID, health, sleep, description);
		}
		return c;
	}

	public static void editCard() {
		Card c = null;
		Deck master = null;
		try {
			int edition = ConsoleIO.promptForInt("Which edition would you like to modify? ", 1, Integer.MAX_VALUE);
			boolean editAnotherCard = true;
			master = (Deck) Tool.deserialize("deck/" + edition + "/master.dc");
			while (editAnotherCard) {
				String[] allCards = Tool.toStrArr(master.getDeck());
				int cardNum = ConsoleIO.promptForMenuSelection(allCards, true);
				if (cardNum == 0) {
					editAnotherCard = false;
				} else {
					boolean done = false;
					c = master.getDeck().get(cardNum - 1);
					while (!done) {
						System.out.println(c.getName() + ":");
						try {
							Creature creature = (Creature) c;
							String[] attr = { "Name", "Rank", "Cost", "Mana Cost", "Power", "Power ID", "Description",
									"Max Health", "Sleep" };
							int selection = ConsoleIO.promptForMenuSelection(attr, true);
							switch (selection) {
							case 1:
								String name = ConsoleIO.promptForInput("Enter the card's name: ", false);
								creature.setName(name);
								break;
							case 2:
								CardRank[] crArr = CardRank.values();
								String[] options = new String[crArr.length];
								int i = 0;
								for (CardRank cr : crArr) {
									options[i] = cr.toString();
									i++;
								}
								int rank = ConsoleIO.promptForMenuSelection(options, false) - 1;
								if (rank != 0) {
									creature.setRank(crArr[rank]);
								}
								break;
							case 3:
								int cost = ConsoleIO.promptForInt("How much will this card cost in the store? ", 0,
										Integer.MAX_VALUE);
								creature.setCost(cost);
								break;
							case 4:
								int manaCost = ConsoleIO.promptForInt("How much mana will this card cost? ", 0,
										Integer.MAX_VALUE);
								creature.setManaCost(manaCost);
								break;
							case 5:
								int power = ConsoleIO.promptForInt("How much damage will this card have? ", 0,
										Integer.MAX_VALUE);
								creature.setPower(power);
								break;
							case 6:
								String[] powerIds = Tool.toStrArr(PowerID.values());
								PowerID powerID = PowerID.values()[ConsoleIO.promptForMenuSelection(powerIds, false)-1];
								creature.setPowerID(powerID);
								break;
							case 7:
								String description = "";
								boolean more = true;
								while (more) {
									description = ConsoleIO.promptForInput("Enter the card's description: ", true);
									more = ConsoleIO.promptForBool("Would you like to add another line? (y/n) ", "n",
											"y");
								}
								creature.setDescription(description);
								break;
							case 8:
								int health = ConsoleIO.promptForInt("How much health will this card have? ", 0,
										Integer.MAX_VALUE);
								creature.setMaxHealth(health);
								creature.setHealth(health);
								break;
							case 9:
								boolean sleep = ConsoleIO.promptForBool("Will this card sleep before attack? ", "y",
										"n");
								creature.setSleep(sleep);
								break;
							case 0:
								done = true;
								break;
							}
							c = creature;
						} catch (ClassCastException e) {
							Spell spell = (Spell) c;
							String[] attr = { "Name", "Rank", "Cost", "Mana Cost", "Power", "Power ID", "Description" };
							int selection = ConsoleIO.promptForMenuSelection(attr, true);
							switch (selection) {
							case 1:
								String name = ConsoleIO.promptForInput("Enter the card's name: ", false);
								spell.setName(name);
								break;
							case 2:
								CardRank[] crArr = CardRank.values();
								String[] options = new String[crArr.length];
								int i = 0;
								for (CardRank cr : crArr) {
									options[i] = cr.toString();
									i++;
								}
								int rank = ConsoleIO.promptForMenuSelection(options, false) - 1;
								spell.setRank(crArr[rank]);
								break;
							case 3:
								int cost = ConsoleIO.promptForInt("How much will this card cost in the store? ", 0,
										Integer.MAX_VALUE);
								spell.setCost(cost);
								break;
							case 4:
								int manaCost = ConsoleIO.promptForInt("How much mana will this card cost? ", 0,
										Integer.MAX_VALUE);
								spell.setManaCost(manaCost);
								break;
							case 5:
								int power = ConsoleIO.promptForInt("How much damage will this card have? ", 0,
										Integer.MAX_VALUE);
								spell.setPower(power);
								break;
							case 6:
								String[] powerIds = Tool.toStrArr(PowerID.values());
								PowerID powerID = PowerID.values()[ConsoleIO.promptForMenuSelection(powerIds, false)-1];
								spell.setPowerID(powerID);
								break;
							case 7:
								String description = "";
								while (!done) {
									description += ConsoleIO.promptForInput("Enter the card's description: ", true);
									done = ConsoleIO.promptForBool("Would you like to add another line? (y/n) ", "n",
											"y");
								}
								spell.setDescription(description);
								break;
							case 0:
								done = true;
								break;
							}
							c = spell;
						}
					}
					master.getDeck().remove(cardNum - 1);
					master.addCard(c);
				}
			}
			Tool.serialize(master, "deck/" + edition + "/master.dc");
			System.out.println("Master Deck Serialized");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
