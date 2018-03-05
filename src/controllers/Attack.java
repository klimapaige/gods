package controllers;

import card.Card;
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
		Card card1, card2;
		if(chooseCard[0]>-1) {
			card1=myHand[chooseCard[0]];
			if(chooseCard[1]>-1) {
				card2=myBattlefeild[chooseCard[1]];
			} else if(chooseCard[2]>-1) {
				card2=myBattlefeild[chooseCard[2]];
			}
		} else if(chooseCard[1]>-1) {
			card1=myBattlefeild[chooseCard[1]];
			if(chooseCard[2]>-1) {
				card2=myBattlefeild[chooseCard[2]];
			}
		}
		
	}
	
	private void headToHead(Card card1, Card card2) {
		PowerID powerID = card1.powerID;
		switch(powerID) {
		case DAMAGE:
			
			break;
		case HEAL:
			break;
		case STUN:
			break;
		case POWER_UP_OFFENSE:
			break;
		case POWER_UP_DEFENSE:
			break;
		case POWER_UP_BOTH:
			break;
		case POWER_DOWN_OFFENSE:
			break;
		case POWER_DOWN_DEFENSE:
			break;
		case POWER_DOWN_BOTH:
			break;
		}
		
	}
	
	
}
