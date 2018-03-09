package controllers;

import card.Card;
import card.Creature;
import card.Spell;
import enums.PowerID;
import player.Player;

public class Attack {
	Player attacker, attackie;
	Card[] myHand;
	Card[] myBattlefield;
	Card[] theirBattleField;

	public Attack(Player attacker, Player attackie, Card[] myHand, Card[] myBattlefeild, Card[] theirBattleField) {
		this.attacker = attacker;
		this.attackie = attackie;
		this.myHand = myHand;
		this.myBattlefield = myBattlefeild;
		this.theirBattleField = theirBattleField;
	}

	public void attackRound(int[] chooseCard) {
		// if a player was chosen
		if (chooseCard[3] > -1) {
			Player player = null;
			Card card = null;
			// decide the player that is affected by the card
			if (chooseCard[3] == 1) {
				player = attacker;
			} else if (chooseCard[3] == 2) {
				player = attackie;
			}
			// choose which card is going to do the affecting
			if (chooseCard[0] > -1) {
				card = myHand[chooseCard[0]];
			} else if (chooseCard[1] > -1) {
				card = myBattlefield[chooseCard[1]];
			}
			if(player!=null&&card!=null) {
			cardVsPlayer(player, card);
			}
			// removes the card from the the hand or battlefield
			if (chooseCard[0] > -1) {
				myHand[chooseCard[0]] = null;
			} else if (chooseCard[1] > -1) {
				myBattlefield[chooseCard[1]] = null;
			}

		} else {// two cards are chosen
			Card card1 = null, card2 = null;
			// if a card from the hand was chosen
			if (chooseCard[0] > -1) {
				card1 = myHand[chooseCard[0]];
				if (chooseCard[1] > -1) {
					card2 = myBattlefield[chooseCard[1]];
				} else if (chooseCard[2] > -1) {
					card2 = myBattlefield[chooseCard[2]];
				}
			} else if (chooseCard[1] > -1) {
				// a card from my battlefield vs a card from their battlefield
				card1 = myBattlefield[chooseCard[1]];
				if (chooseCard[2] > -1) {
					card2 = myBattlefield[chooseCard[2]];
				}
			}if(card1!=null&&card2!=null) {
				card2 = headToHead(card1, card2);				
			}
			if (card2 instanceof Creature) {
				card2 = ((Creature) card2).getHealth() == 0 ? null : card2;
			}
			if (chooseCard[0] > -1) {
				myHand[chooseCard[0]] = null;
				if (chooseCard[1] > -1) {
					myBattlefield[chooseCard[1]] = card2;
				} else if (chooseCard[2] > -1) {
					myBattlefield[chooseCard[2]] = card2;
				}
			} else if (chooseCard[1] > -1) {
				myBattlefield[chooseCard[1]] = null;
				if (chooseCard[2] > -1) {
					myBattlefield[chooseCard[2]] = card2;
				}
			}

		}
	}

	// pass in the two cards that go against each other and depending on
	// power id, the first card affects the second card
	private Card headToHead(Card card1, Card card2) {
		PowerID powerID = card1.getPowerID();
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

	private void cardVsPlayer(Player player, Card card) {
		if (card != null) {
			PowerID powerID = card.getPowerID();
			switch (powerID) {
			case DAMAGE:
				int health1 = player.getHealth();
				health1 -= card.getPower();
				player.setHealth(health1);
				break;
			case HEAL:
				if(card instanceof Spell) {
					int health2 = player.getHealth();
					health2 += card.getPower();
					player.setHealth(health2);					
				}
				break;
			default: 
				if(card instanceof Creature) {
					int health2 = player.getHealth();
					health2 -= card.getPower();
					player.setHealth(health2);					
				}
				break;
			} 
		}
	}

}
