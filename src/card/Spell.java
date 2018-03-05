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
		builder.append("Spell [name=");
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
