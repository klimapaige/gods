package card;

import enums.CardRank;
import enums.GodType;
import player.Player;

@SuppressWarnings("serial")
public class Creature extends Card {

	private int sleep;
	
	public Creature(String name, CardRank rank, int cost, int manaCost, int damage, int health, String description, int sleep) {
		super(name, rank, cost, manaCost, damage, health, description);
		this.sleep = sleep;
	}

	@Override
	public void cardAbility(Player player) {
		// TODO Auto-generated method stub
		
	}

	
}
