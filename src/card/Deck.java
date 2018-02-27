package card;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import enums.GodType;
import lib.ConsoleIO;
import lib.Tool;
import player.God;

@SuppressWarnings("serial")
public class Deck implements Serializable {

	private ArrayList<Card> deck = new ArrayList<>();
	private boolean isStarter;
	private GodType godType;
	private String name;

	public Deck(String name) {
		setName(name);
	}

	public Deck(God god) {

	}

	public Deck(boolean admin) {
		Deck master = null;
		try {
			master = (Deck) Tool.deserialize("/deck/1/master.dc");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		String name = ConsoleIO.promptForInput("What are you naming your deck?", false);
		Deck newDeck = new Deck(name);
		boolean done = false;
		while (!done) {
			boolean newCard = ConsoleIO.promptForBool("Do you want to add an existing card to your new Deck?", "y",
					"n");
			Card c = null;
			if (newCard) {
				c = Card.newCard();
			} else {
				String[] allCards = Tool.toStrArr(master.getDeck());
				boolean addAnotherCard = true;
				while (addAnotherCard) {
					int selection = ConsoleIO.promptForMenuSelection(allCards, true);
					if(selection == 0) {
						addAnotherCard = false;
					}else {
						c = 
					}
				}
			}
		}
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public void shuffle() {

		int len = deck.size();
		Random rand = new Random();
		ArrayList<Card> newDeck = new ArrayList<>();
		for (int i = 0; i != len; len--) {
			newDeck.add(getDeck().get(rand.nextInt(len - 1)));
		}
	}

	public void addCard(Card c) {
		getDeck().add(c);
	}

	public Card pullCard() {
		int index = getDeck().size();
		Card c = getDeck().get(index);
		getDeck().remove(index);
		return c;
	}

	public boolean isStarter() {
		return isStarter;
	}

	public void setStarter(boolean isStarter) {
		this.isStarter = isStarter;
	}

	public GodType getGodType() {
		return godType;
	}

	public void setGodType(GodType godType) {
		this.godType = godType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
