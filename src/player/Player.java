package player;

import card.Deck;

public class Player 
{
	private String username;
	private Deck deck;
	private int mana;
	private int health;
	private God god;
	private int credit;
	
	public Player(String username)
	{
		
		setCredit(0);
		setHealth(20);
		setMana(20);
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public int getMana()
	{
		return mana;
	}
	
	public void setMana(int mana)
	{
		this.mana = mana;
	}
	
	public int getCredit()
	{
		return credit;
	}
	
	public void setCredit(int credit)
	{
		this.credit = credit;
	}
}
