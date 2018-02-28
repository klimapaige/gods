package card;

import enums.CardRank;
import player.Player;

@SuppressWarnings("serial")
public class Creature extends Card {

	private int sleep;
	private final int MAX_HEALTH;
	private int currentHealth;
	
	public Creature(String name, CardRank rank, int cost, int manaCost, int damage, int health, int maxHealth, String description, int sleep) {
		super(name, rank, cost, manaCost, damage, health, description);
		MAX_HEALTH = maxHealth;
		this.setSleep(sleep);
		this.setCurrentHealth(maxHealth);
	}

	@Override
	public void cardAbility(Player player) {
		// TODO Auto-generated method stub
		
	}

	public int getMAX_HEALTH() {
		return MAX_HEALTH;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getSleep() {
		return sleep;
	}

	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	
}
