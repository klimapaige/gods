package controllers;

import java.util.ArrayList;

import card.Card;
import player.Player;

public class Match {
	private ArrayList<Card> firstPlayedCards = new ArrayList<>();
	private ArrayList<Card> secondPlayedCards = new ArrayList<>();
	
	public void start() {
	}
	
	public void turn() {
		drawCards();
		attack();
		defend();
	}
	
	public boolean checkWin() {
		boolean win = false;
		
		return win;
	}
	
	public void drawCards() {
		
	}
	
	public void end() {
		
	}
	
	public void attack() {
		
	}
	
	public void defend() {
		
	}
	
}
