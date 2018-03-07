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
		builder.append("Creature:\tName: ");
		builder.append(name);
		if(name.length() < 10) {
			builder.append("\t");
		}
		builder.append("\tRank: ");
		builder.append(rank);
		builder.append("\tCost: ");
		builder.append(getCost());
		builder.append("\tMana Cost: ");
		builder.append(manaCost);
		builder.append("\tMax Health: ");
		builder.append(maxHealth);
		builder.append("\tPower: ");
		builder.append(getPower());
		builder.append("\tSleep: ");
		builder.append(sleep);
		builder.append("\tDescription: ");
		builder.append(description);
		return builder.toString();
	}

}
