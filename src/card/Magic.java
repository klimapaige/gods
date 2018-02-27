package card;

import enums.CardRank;
import enums.GodType;
import player.Player;

public class Magic extends Card{

	public Magic(String name, CardRank rank, int cost, int manaCost, int damage, GodType type, String description) {
		super(name, rank, cost, manaCost, damage, type, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dealDamage(Player player) {
		// TODO Auto-generated method stub
		
	}

}
