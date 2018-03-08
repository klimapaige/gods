package controllers;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import enums.GodType;
import player.Player;
import player.Players;
import traders.Shop;
import traders.Trade;
import viewer.Main_MenuController;
import viewer.View;

public class Game {

	private static View view;
	private static ArrayList<Player> players = new ArrayList<>();
	private String[] args;
	private static Players playersHash;
	
	public static View getView() {
		return view;
	}
	
	public static ArrayList<Player> getPlayers() {
		return players;
	}
	
	public static Players getPlayersHash() {
		return playersHash;
	}
	
	public static void setPlayerHashNew() {
		playersHash = new Players(true, "C:\\Users\\Joe Hommel\\Desktop\\temp.pl");
	}
	
	public static void setPlayerHashOld(String filePath) {
		playersHash = new Players(false, filePath);
		String[] playersHashArray = new String[playersHash.getPlayerList().keySet().size()];
		playersHash.getPlayerList().keySet().toArray(playersHashArray);
		for (int i = 0; i < playersHash.getPlayerList().keySet().size(); i++) {
			String key = playersHashArray[i];
			players.add(playersHash.getPlayerList().get(key));
		}
	}

	public Game(View view, String[] args) {
		this.view = view;
		this.args = args;
		view.launchGUI(args);
	}

	public static void mainMenu() {
//		view.launchGUI(args);
//		String[] options = { "Log in", "PlayGame", "Shop", "Trade", "Delete a Player", "Make a new player" };
		
		
//		int choice = view.displayMenu(options);
//		switch (choice) {
//		case 0:
//			login();
//			break;
//		case 1:
//			playGame();
//			break;
//		case 2:
//			shop();
//			break;
//		case 3:
//			trade();
//			break;
//		case 4:
//			delete();
//			break;
//		case 5:
//			newPlayer();
//			break;
//		}
	}

	public void login() {
		String username = view.loginScreen();

	}

	public void playGame() {
		if (players.size() > 1) {
			String[] options = new String[players.size()];
			options = players.toArray(options);
//			int firstOption = view.displayMenu(options);
//			int secondOptions = view.displayMenu(options);
//			Match m = new Match(players.get(0), players.get(1), view);
//			m.runGame();
		}
	}

	public void shop() {
		String[] options = new String[players.size()];
		options = players.toArray(options);
		int input = view.displayMenu(options);
		Shop s = new Shop(players.get(input));
		s.shop();
	}

	public void trade() {
		if (players.size() > 1) {
			String[] options = new String[players.size()];
			options = players.toArray(options);
			int firstOptions = view.displayMenu(options);
			int secondOption = view.displayMenu(options);
			Trade t = new Trade(players.get(firstOptions), players.get(secondOption));
			t.beginTrade();
		}
	}

	public void delete() {
		String[] options = new String[players.size()];
		options = players.toArray(options);
		int input = view.displayMenu(options);
		players.remove(input);
	}

	public static void newPlayer() {
		ArrayList<String> info = view.getInformation();
		Player p = new Player((String) info.get(0), (String) info.get(1), GodType.valueOf((String) info.get(2)));
		playersHash.addPlayer(p);
		players.add(p);
	}
	
	public static void addNewPlayer() {
		ArrayList<String> info = view.getNewInformation();
		Player p = new Player((String) info.get(0), (String) info.get(1), GodType.valueOf((String) info.get(2)));
		playersHash.addPlayer(p);
		players.add(p);
	}

}
