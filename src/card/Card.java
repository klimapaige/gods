package card;

import java.io.Serializable;

import enums.CardRank;
import enums.PowerID;

public abstract class Card implements Serializable {

	private static final long serialVersionUID = 8241558901048926297L;
	protected String name;
	protected CardRank rank;
	protected int cost;
	protected int manaCost;
	protected int power;
	protected PowerID powerID;
	protected String description;

	public Card(String name, CardRank rank, int cost, int manaCost, int power, PowerID powerID, String description) {
		super();
		setName(name);
		setRank(rank);
		setCost(cost);
		setManaCost(manaCost);
		setPower(power);
		setDescription(description);
		setPowerID(powerID);
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if (power >= 0) {
			this.power = power;
		} else {
			this.power = 0;
		}
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CardRank getRank() {
		return rank;
	}

	public void setRank(CardRank rank) {
		this.rank = rank;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	public PowerID getPowerID() {
		return powerID;
	}

	public void setPowerID(PowerID powerID) {
		this.powerID = powerID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
