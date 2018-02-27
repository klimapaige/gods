package card;

import java.util.ArrayList;
import java.util.Random;

import player.God;

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<>();
	
	public Deck() {
		
	}
	
	public Deck(God god) {
		
	}
	
	public Deck(boolean admin) {
		if(admin) {
			
		}else if(admin) {
			
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
		for(int i = 0; i != len; len--) {
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
	
}
