package card;

import enums.CardRank;
import enums.PowerID;

public class Creature extends Card {

	private static final long serialVersionUID = -1604270793646181661L;
	private boolean sleep;
	private int maxHealth;
	private int health;

	public Creature(String name, CardRank rank, int cost, int manaCost, int power, PowerID powerID, int health,
			boolean sleep, String description) {
		super(name, rank, cost, manaCost, power, powerID, description);
		setMaxHealth(health);
		setHealth(health);
		setSleep(sleep);
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public boolean getSleep() {
		return sleep;
	}

	public void setSleep(boolean sleep) {
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
		builder.append(maxHealth);
		builder.append(", health=");
		builder.append(health);
		builder.append(", name=");
		builder.append(name);
		builder.append(", rank=");
		builder.append(rank);
		builder.append(", cost=");
		builder.append(getCost());
		builder.append(", manaCost=");
		builder.append(manaCost);
		builder.append(", power=");
		builder.append(getPower());
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
