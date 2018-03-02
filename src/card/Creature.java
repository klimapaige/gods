package card;

import enums.CardRank;
import player.Player;

public class Creature extends Card {

	private static final long serialVersionUID = -1604270793646181661L;
	private int sleep;
	private final int MAX_HEALTH;
	private int health;
	
	public Creature(String name, CardRank rank, int cost, int manaCost, int power,int powerID, int health, int sleep, String description) {
		super(name, rank, cost, manaCost, power, powerID, description);
		MAX_HEALTH = health;
		setHealth(health);
		setSleep(sleep);
	}

	// 0 damage, 1 Heal, 2 Stun, 10 power up Off., 11 power up Def., 12 power Both

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Creature [sleep=");
		builder.append(sleep);
		builder.append(", MAX_HEALTH=");
		builder.append(MAX_HEALTH);
		builder.append(", health=");
		builder.append(health);
		builder.append(", name=");
		builder.append(name);
		builder.append(", rank=");
		builder.append(rank);
		builder.append(", cost=");
		builder.append(cost);
		builder.append(", manaCost=");
		builder.append(manaCost);
		builder.append(", power=");
		builder.append(power);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

	
}
