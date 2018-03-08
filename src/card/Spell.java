package card;

import enums.CardRank;
import enums.PowerID;

public class Spell extends Card {

	private static final long serialVersionUID = 3653971824268444554L;

	public Spell(String name, CardRank rank, int cost, int manaCost, int power, PowerID powerID, String description) {
		super(name, rank, cost, manaCost, power, powerID, description);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Spell:\tName: ");
		builder.append(name);
		if (name.length() < 10) {
			builder.append("\t");
		}
		builder.append("\tRank: ");
		builder.append(rank);
		builder.append("\tCost: ");
		builder.append(getCost());
		builder.append("\tMana Cost: ");
		builder.append(manaCost);
		builder.append("\tPower: ");
		builder.append(getPower());
		builder.append("\tDescription: ");
		builder.append(description);
		return builder.toString();
	}

}
