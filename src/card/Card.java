package card;

import java.io.Serializable;

import enums.CardRank;
import enums.PowerID;
import lib.ConsoleIO;
import lib.Tool;

public abstract class Card implements Serializable {

	private static final long serialVersionUID = 8241558901048926297L;
	public final String name;
	public final CardRank rank;
	private int cost;

	public final int manaCost;
	private int power;
	public final PowerID powerID;
	public final String description;

	public Card(String name, CardRank rank, int cost, int manaCost, int power, PowerID powerID, String description) {
		super();
		this.name = name;
		this.rank = rank;
		this.cost = cost;
		this.manaCost = manaCost;
		this.power = power;
		this.description = description;
		this.powerID = powerID;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if(power>=0) {
			this.power = power;			
		}else {
			this.power = 0;
		}
	}
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	

}
