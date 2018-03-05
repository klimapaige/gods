package controllers;

import card.Card;
import card.Creature;
import enums.PowerID;
import player.Player;

public class Attack {
	Player attacker, attackie;
	Card[] myHand;
	Card[] myBattlefeild;
	Card[] theirBattleFeild;

	public Attack(Player attacker, Player attackie, Card[] myHand, Card[] myBattlefeild, Card[] theirBattleFeild) {
		this.attacker = attacker;
		this.attackie = attackie;
		this.myHand = myHand;
		this.myBattlefeild = myBattlefeild;
		this.theirBattleFeild = theirBattleFeild;
	}

	public void attackRound(int[] chooseCard) {
		Card card1 = null, card2 = null;
		if (chooseCard[0] > -1) {
			card1 = myHand[chooseCard[0]];
			if (chooseCard[1] > -1) {
				card2 = myBattlefeild[chooseCard[1]];
			} else if (chooseCard[2] > -1) {
				card2 = myBattlefeild[chooseCard[2]];
			}
		} else if (chooseCard[1] > -1) {
			card1 = myBattlefeild[chooseCard[1]];
			if (chooseCard[2] > -1) {
				card2 = myBattlefeild[chooseCard[2]];
			}
		}
		card2 = headToHead(card1, card2);
		if (card2 instanceof Creature) {
			card2 = ((Creature) card2).getHealth()==0?null:card2;
		}
		
		if (chooseCard[0] > -1) {
			myHand[chooseCard[0]] = null;
			if (chooseCard[1] > -1) {
				myBattlefeild[chooseCard[1]]= card2;
			} else if (chooseCard[2] > -1) {
				myBattlefeild[chooseCard[2]]= card2;
			}
		} else if (chooseCard[1] > -1) {
			myBattlefeild[chooseCard[1]]= null;
			if (chooseCard[2] > -1) {
				myBattlefeild[chooseCard[2]]= card2;
			}
		}
	}

	private Card headToHead(Card card1, Card card2) {
		PowerID powerID = card1.powerID;
		int power = 0;
		switch (powerID) {
		case DAMAGE:
			if (card2 instanceof Creature) {
				int health = ((Creature) card2).getHealth();
				health -= card1.getPower();
				((Creature) card2).setHealth(health);
			}
			break;
		case HEAL:
			if (card2 instanceof Creature) {
				int health = ((Creature) card2).getHealth();
				health += card1.getPower();
				((Creature) card2).setHealth(health);
			}
			break;
		case STUN:
			if (card2 instanceof Creature) {
				((Creature) card2).setSleep(true);
			}
			break;
		case POWER_UP_OFFENSE:
			power = card2.getPower();
			power += card1.getPower();
			card2.setPower(power);
			break;
		case POWER_UP_BOTH:
			if (card2 instanceof Creature) {
				int health = ((Creature) card2).getHealth();
				health += card1.getPower();
				power = card2.getPower();
				power += card1.getPower();
				((Creature) card2).setHealth(health);
				card2.setPower(power);
			}
			break;
		case POWER_DOWN_OFFENSE:
			power = card2.getPower();
			power -= card1.getPower();
			card2.setPower(power);
			break;
		case POWER_DOWN_BOTH:
			if (card2 instanceof Creature) {
				int health = ((Creature) card2).getHealth();
				health -= card1.getPower();
				power = card2.getPower();
				power -= card1.getPower();
				((Creature) card2).setHealth(health);
				card2.setPower(power);
			}
			break;
		}
		return card2;
	}

}
