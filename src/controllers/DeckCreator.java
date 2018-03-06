package controllers;

import card.Decks;
import lib.ConsoleIO;

public class DeckCreator {

	public static void run() {
		System.out.println("Welcome to the deck creation tool.");
		boolean done = false;
		String[] prompt = { "Add new deck", "Remove deck", "Edit deck" };
		while (!done) {
			int selection = ConsoleIO.promptForMenuSelection(prompt, true);
			switch (selection) {
			case 1:
				Decks.newDeck();
				break;
			case 2:
				System.out.println("Not available yet, delete decks manually.");
				break;
			case 3:
				Decks.editDeck();
				break;
			case 0:
				done = true;
				break;
			default:
				break;
			}
		}
	}
}
