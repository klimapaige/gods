package card;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import enums.GodType;
import lib.Tool;
import player.God;

public class Deck implements Serializable {

	private static final long serialVersionUID = -135494035811112623L;
	private ArrayList<Card> deck = new ArrayList<>();
	public final boolean isStarter;
	private GodType godType;
	private String name;

	public Deck(String name, boolean isStarter) {
		setName(name);
		this.isStarter = isStarter;
	}

	public Deck(God god) {
		String filePath = "deck/1/" + god.godName.toLowerCase() + ".dc";
		Deck deck = null;
		try {
			deck = (Deck) Tool.deserialize(filePath);
			setDeck(deck.getDeck());
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		setGodType(god.type);
		setName(god.godName);
		if (deck != null) {
			this.isStarter = deck.isStarter;
		} else {
			this.isStarter = false;
		}
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public Card getCard(int index) {
		return deck.get(index);
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
		int index = getDeck().size() - 1;
		Card c = getDeck().get(index);
		getDeck().remove(index);
		return c;
	}

	public Card pullCard(int index) {
		Card c = getDeck().get(index);
		getDeck().remove(index);
		return c;
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
