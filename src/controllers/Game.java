package controllers;

import java.util.ArrayList;

import enums.GodType;
import player.Player;
import viewer.View;

public class Game {
	
	private View view;
	private ArrayList<Player> players;
	
	public Game(View view)
	{
		this.view = view;
	}
	
	public void mainMenu() {
		int choice = view.displayMenu();
		switch(choice)
		{
		case 1:
			playGame();
			break;
		case 2: 
			shop();
			break;
		case 3:
			trade();
			break;
		case 4:
			delete();
			break;
		case 5:
			newPlayer();
			break;
		}
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
	
	public void delete() {
		
	}
	
	public void newPlayer() {
		String[] info = view.getInformation();
		Player p = new Player(info[0], GodType.valueOf(info[1]));
		players.add(p);
	}
	
}
