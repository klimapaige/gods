package player;

import java.io.Serializable;
import java.util.Random;

import card.Deck;
import enums.GodType;
import enums.Mythology;

public class Player implements Serializable{
	private String username;
	private Deck deck;
	private int mana;
	private int health;
	private God god;
	private int credit;

	public Player(String username, GodType godtype) {
		setUsername(username);
		Random rand = new Random();
		Mythology[] mythos = Mythology.values();
		Mythology mythology = mythos[rand.nextInt(mythos.length)];
		God playerGod = new God(godtype, mythology);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {

	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {

	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public God getGod() {
		return god;
	}

	public void setGod(God god) {
		this.god = god;
	}
}
