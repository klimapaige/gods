package card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import enums.CardRank;
import lib.ConsoleIO;
import player.God;

public class Deck implements Serializable {

	private ArrayList<Card> deck = new ArrayList<>();
	private boolean isStarter;

	public Deck() {

	}

	public Deck(God god) {

	}

	public Deck(boolean admin) {
		
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

}
