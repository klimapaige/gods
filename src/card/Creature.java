package card;

import enums.CardRank;
import enums.GodType;
import player.Player;

@SuppressWarnings("serial")
public class Creature extends Card{

	public Creature(String name, CardRank rank, int cost, int manaCost, int damage, int health, String description) {
		super(name, rank, cost, manaCost, damage, health, description);
	}

	@Override
	public void cardAbility(Player player) {
		// TODO Auto-generated method stub
		
	}

	
}
