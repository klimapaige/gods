package controllers;

import player.Player;
import viewer.View;

public class Game {
	
	private View view;
	
	public Game(View view)
	{
		this.view = view;
	}
	
	public void mainMenu() {
		
	}

	public void loginScreen() {
		
	}
	
	public void playGame() {
		Match m = new Match();
		m.start();
	}
	
	public void shop() {
		
	}
	
	public void trade() {
		
	}
	
	public void reset() {
		
	}
	
	public void newPlayer() {
		
		Player p = new Player();
		
	}
	
}
