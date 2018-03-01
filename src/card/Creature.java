package card;

import enums.CardRank;
import player.Player;

@SuppressWarnings("serial")
public class Creature extends Card {

	private int sleep;
	private final int MAX_HEALTH;
	private int health;
	
	public Creature(String name, CardRank rank, int cost, int manaCost, int power, int health, int sleep, String description) {
		super(name, rank, cost, manaCost, power, description);
		MAX_HEALTH = health;
		setHealth(health);
		setSleep(sleep);
	}

	@Override
	public void cardAbility(Player player) {
		// TODO Auto-generated method stub
		
	}

	public int getMAX_HEALTH() {
		return MAX_HEALTH;
	}

	public int getSleep() {
		return sleep;
	}

	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	
}
