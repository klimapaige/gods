package controllers;

import java.io.IOException;

import card.Cards;
import card.Deck;
import card.Decks;
import lib.ConsoleIO;
import lib.Tool;

public class DeckCreator {

	public static void run() {
		System.out.println("Welcome to the deck creation tool.");
		boolean done = false;
		String[] prompt = { "Add new deck", "Remove deck", "Edit deck", "Edit Master Card (Requires Admin Code)", "Remove Master Card (Requires admin code)", };
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
			case 4:
				Cards.editCard();
				break;
			case 5:
				String isAdmin = ConsoleIO.promptForInput("Enter the code: ", true);
				Deck master = null;
				if (isAdmin.equals("PJMJ")) {
					int edition = ConsoleIO.promptForInt("Which edition would you like to get the deck from? ", 1,
							Integer.MAX_VALUE);
					try {
						master = (Deck) Tool.deserialize("deck/" + edition + "/master.dc");
						String[] allCards = Tool.toStrArr(master.getDeck());
						int cardNum = ConsoleIO.promptForMenuSelection(allCards, true);
						master.getDeck().remove(cardNum - 1);
					} catch (ClassNotFoundException | IOException e) {
						e.printStackTrace();
					}

				} else {
					System.out.println("You are not authorized to delete master card data.");
				}

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
