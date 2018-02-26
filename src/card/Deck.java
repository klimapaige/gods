package card;

import java.util.ArrayList;

import player.God;

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<>();
	private ArrayList<Card> hand = new ArrayList<>();
	
	public Deck(God god) {
		
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
}
