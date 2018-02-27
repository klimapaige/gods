package controllers;

import java.util.ArrayList;

import enums.GodType;
import player.Player;
import viewer.View;

public class Game {
	
	private View view;
	private ArrayList<Player> players;
	private String[] args;
	
	public Game(View view, String[] args)
	{
		this.view = view;
		this.args = args;
	}
	
	public void mainMenu() {
		view.launchGUI(args);
		String[] options = {"Log in", "PlayGame", "Shop", "Trade", "Delete a Player", "Make a new player"};
		int choice = view.displayMenu(options);
		switch(choice)
		{
		case 0:
			loginScreen();
			break;
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
		String[] options = new String[players.size()];
		options = players.toArray(options);
		int input = view.displayMenu(options);
		players.remove(input);
	}
	
	public void newPlayer() {
		String[] info = view.getInformation();
		Player p = new Player(info[0], GodType.valueOf(info[1]));
		players.add(p);
	}
	
}
