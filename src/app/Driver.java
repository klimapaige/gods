package app;

import controllers.Game;
import viewer.GuiView;

public class Driver {

	public static void main(String[] args) {
		Game game = new Game(new GuiView(), args);
		// sgame.mainMenu();
	}
}
