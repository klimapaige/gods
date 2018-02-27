package card;

import enums.CardRank;
import enums.GodType;
import player.Player;

public class Creature extends Card{

	public Creature(String name, CardRank rank, int cost, int manaCost, int damage, GodType type, String description) {
		super(name, rank, cost, manaCost, damage, type, description);
	}

	@Override
	public void dealDamage(Player player) {
		player.setHealth(player.getHealth() - damage);
	}
	
	
}
