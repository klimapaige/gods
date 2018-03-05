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
		this.view = view;
	}
	
	public void runGame() {
		start();
		int turnCount = 0;
		int playerTurn = (int) (Math.random()*2);
		
		while(checkWin()==null) {
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
			attack(playerTurn);
			board.drawCard(playerTurn,attacker);
		}
	}
	
	public Player checkWin() {
		Player win = null;
		if(player1.getHealth()<=0&&player2.getHealth()>0) {
			win=player2;
		}else if(player2.getHealth()<=0&&player1.getHealth()>0) {
			win=player1;
		}else if(player2.getHealth()<=0&&player1.getHealth()<=0) {
			player1.setHealth(10);
			player2.setHealth(10);
		}
		return win;
	}

	
	
	public void attack(int playerTurn) {
		int[] cardChoices = new int[2];
		Card[] bF1 = board.getBattlefeild1();
		Card[] bF2 = board.getBattlefeild1();
		if(playerTurn==1) {
			//bF1[cardChoices[0]].cardAbility(player, card);
		}
		
	}
	
	public void end() {
		
	}
	
}
