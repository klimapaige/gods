package controllers;

import java.util.ArrayList;

import card.Board;
import card.Card;
import card.Deck;
import player.Player;
import viewer.View;

public class Match {
	private Player player1;
	private Player player2;
	private Board board = new Board();
	View view;
	
	public Match(Player player1,Player player2, View view) {
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
		board.drawFirstCards(player1, player2);	
	}
	
	public void turn(int playerTurn) {
		Player attacker;
		for(int i =0;i<2;i++) {
			if(playerTurn%2==1) {
				playerTurn=1;
				attacker = player1;
			} else {
				playerTurn=2;
				attacker = player2;
			}
			attack(attacker);
			board.drawCard(playerTurn,attacker);
		}
	}
	
	public boolean checkWin() {
		boolean win = false;
		
		return win;
	}

	
	
	public void attack(Player player) {
		
	}
	
	public void end() {
		
	}
	
}
