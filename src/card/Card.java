package card;

import enums.CardRank;
import enums.GodType;
import player.Player;

public abstract class Card {

	public final String name;
	public final CardRank rank;
	public final int cost;
	public final int manaCost;
	public final int damage;
	public final GodType type;
	public final String description;
	
	public Card(String name, CardRank rank, int cost, int manaCost, int damage, GodType type, String description) {
		super();
		this.name = name;
		this.rank = rank;
		this.cost = cost;
		this.manaCost = manaCost;
		this.damage = damage;
		this.type = type;
		this.description = description;
	}
	
	public abstract int dealDamage(Player player);
	
}
