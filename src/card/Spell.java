package card;

import enums.CardRank;
import player.Player;

public class Spell extends Card{

	private static final long serialVersionUID = 3653971824268444554L;

	public Spell(String name, CardRank rank, int cost, int manaCost, int power, int powerID, String description) {
		super(name, rank, cost, manaCost, power, powerID, description);
	}

	@Override
	public void cardAbility(Player player,Card[] battlefeild) {
		// 0 damage, 1 Heal, 2 Stun, 10 power up Off., 11 power up Def., 12 power Both
		
		
		
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
