package app;

import card.Deck;
import lib.ConsoleIO;

public class DeckCreatorDriver {

	public static void main(String[] args) {

		System.out.println("Welcome to the deck creation tool.");
		boolean done = false;
		String[] prompt = { "Add new deck", "Remove deck" };
		while (!done) {
			int selection = ConsoleIO.promptForMenuSelection(prompt, true);
			switch (selection) {
			case 1:
				Deck.newDeck(true);
				break;
			case 2:
				System.out.println("Not available yet, delete decks manually.");
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
