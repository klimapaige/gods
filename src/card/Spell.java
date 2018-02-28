package card;

import enums.CardRank;
import player.Player;

@SuppressWarnings("serial")
public class Spell extends Card{

	public Spell(String name, CardRank rank, int cost, int manaCost, int damage, int health, String description) {
		super(name, rank, cost, manaCost, damage, health, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cardAbility(Player player) {
		// TODO Auto-generated method stub
		
	}

}
