package controllers;

import viewer.GuiView;

public class Driver {
	
	public static void main(String[] args) {
		Game game = new Game(new GuiView(), args);
		game.mainMenu();
	}
}
