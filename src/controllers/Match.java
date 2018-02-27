package controllers;

import java.util.ArrayList;

import card.Card;
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
		while(!checkWin()) {
			turnCount++;
			if(turnCount == 1) {
				drawFirstCards();
			}else {
				drawCard();
			}
		}
	}
	
	public void start() {
		
	}
	
	public void turn() {
		drawCard();
		attack();
		defend();
	}
	
	public boolean checkWin() {
		boolean win = false;
		
		return win;
	}

	public void drawFirstCards() {
		
	}
	
	public void drawCard() {
		
	}
	
	public void end() {
		
	}
	

	
	public void attack() {
		
	}
	
	public void defend() {
		
	}
	
}
