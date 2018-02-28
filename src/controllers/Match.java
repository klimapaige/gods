package controllers;

import java.util.ArrayList;

import card.Card;
import card.Deck;
import player.Player;

public class Match {
	private Player player1;
	private Player player2;
	
	public Match(Player player1,Player player2) {
		this.player1=player1;
		this.player2=player2;
	}
	
	public void runGame() {
		start();
		int turnCount = 0;
		int playerTurn = (int) (Math.random()*2);
		while(!checkWin()) {
			turnCount++;
			turn(playerTurn);
		}
	}
	
	public void start() {
		drawFirstCards(player1);
		drawFirstCards(player2);
		
	}
	
	public void turn(int playerTurn) {
		Player attacker;
		Player defender;
		for(int i =0;i<2;i++) {
			if(playerTurn%2==0) {
				attacker = player1;
				defender = player2;
			} else {
				attacker = player2;
				defender = player1;
			}
			drawCard(attacker);
			attack(attacker);
			defend(defender);
		}
	}
	
	public boolean checkWin() {
		boolean win = false;
		
		return win;
	}

	public void drawFirstCards(Player player) {
		Deck hand = new Deck(player.getUsername()+" Hand", false);
		for(int i =0;i<5;i++) {
			hand.addCard(player.getDeck().pullCard()); 
		}
		player.setHand(hand);
	}
	
	public void drawCard(Player player) {
		player.getHand().addCard(player.getDeck().pullCard());
	}
	
	public void attack(Player player) {
		
	}
	
	public void defend(Player player) {
		
	}
	
	public void end() {
		
	}
	
}
