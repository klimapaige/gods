package card;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import lib.ConsoleIO;
import lib.Tool;

public class Decks {

	public static void newDeck() {
		Deck master = null;
		try {
			boolean done = false;
			int edition = ConsoleIO.promptForInt("Which edition would you like to get a new deck from? ", 1,
					Integer.MAX_VALUE);
			String name = "master";
			boolean isStarter = false;
			boolean isMaster = true;
			try {
				master = (Deck) Tool.deserialize("deck/" + edition + "/master.dc");
				isMaster = false;
				name = ConsoleIO.promptForInput("What are you naming your deck? ", false);
				isStarter = ConsoleIO.promptForBool("Is this a starter deck? ", "y", "n");
			} catch (FileNotFoundException e) {
				System.out.println("Creating a new edition");
				new File("deck").mkdir();
				new File("deck/" + edition).mkdir();
			}
			Deck newDeck = new Deck(name, isStarter);
			while (!done) {
				String[] prompt = { "Add Card", "Remove Card", "Remove Master Card (Requires admin code)",
						"View Cards" };
				int selection = ConsoleIO.promptForMenuSelection(prompt, true);
				switch (selection) {
				case 1:
					boolean newCard = ConsoleIO.promptForBool(
							"Do you want to add a new card to your new deck or one from the master deck? (n/m) ", "n",
							"m");
					Card c = null;
					if (newCard) {
						c = Cards.newCard();
						if (!isMaster) {
							master.addCard(c);
						}
					} else {
						String[] allCards = Tool.toStrArr(master.getDeck());
						boolean addAnotherCard = true;
						while (addAnotherCard) {
							int cardNum = ConsoleIO.promptForMenuSelection(allCards, true);
							if (cardNum == 0) {
								addAnotherCard = false;
							} else {
								c = master.getDeck().get(cardNum - 1);
							}
							newDeck.addCard(c);
						}
					}
					break;
				case 2:
					String[] cardDeck = Tool.toStrArr(newDeck.getDeck());
					int cardNum = ConsoleIO.promptForMenuSelection(cardDeck, true);
					newDeck.getDeck().remove(cardNum - 1);
					break;
				case 3:
					String isAdmin = ConsoleIO.promptForInput("Enter the code: ", true);
					if (isAdmin.equals("PJMJ")) {
						String[] masterDeck = Tool.toStrArr(newDeck.getDeck());
						int masterCardNum = ConsoleIO.promptForMenuSelection(masterDeck, true);
						newDeck.getDeck().remove(masterCardNum - 1);
					} else {
						System.out.println("You are not authorized to delete master card data.");
					}

					break;
				case 4:
					int i = 0;
					for (Card card : newDeck.getDeck()) {
						i++;
						System.out.println(i + ".) " + card);

					}
					break;
				case 0:
					done = true;
					break;
				default:
					break;
				}

			}
			Tool.serialize(newDeck, "deck/" + edition + "/" + name + ".dc");
			if (!isMaster) {
				Tool.serialize(master, "deck/" + edition + "/master.dc");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void editDeck() {
		Deck master = null;
		try {
			boolean done = false;
			int edition = ConsoleIO.promptForInt("Which edition would you like to get the deck from? ", 1,
					Integer.MAX_VALUE);
			String name = "";
			try {
				master = (Deck) Tool.deserialize("deck/" + edition + "/master.dc");
				name = ConsoleIO.promptForInput("What is the name of your deck? ", false);
				Deck newDeck = (Deck) Tool.deserialize("deck/" + edition + "/" + name + ".dc");
				while (!done) {
					String[] prompt = { "Add Card", "Remove Card", "Edit Master Card",
							"Remove Master Card (Requires admin code)", "View Cards" };
					int selection = ConsoleIO.promptForMenuSelection(prompt, true);
					switch (selection) {
					case 1:
						boolean newCard = ConsoleIO.promptForBool(
								"Do you want to add a new card to your new deck or one from the master deck? (n/m) ",
								"n", "m");
						Card c = null;
						if (newCard) {
							c = Cards.newCard();
							master.addCard(c);
						} else {
							String[] allCards = Tool.toStrArr(master.getDeck());
							boolean addAnotherCard = true;
							while (addAnotherCard) {
								int cardNum = ConsoleIO.promptForMenuSelection(allCards, true);
								if (cardNum == 0) {
									addAnotherCard = false;
								} else {
									c = master.getDeck().get(cardNum - 1);
									newDeck.addCard(c);
								}
							}
						}
						break;
					case 2:
						String[] cardDeck = Tool.toStrArr(newDeck.getDeck());
						int cardNum = ConsoleIO.promptForMenuSelection(cardDeck, true);
						newDeck.getDeck().remove(cardNum - 1);
						break;
					case 3:
						Cards.editCard();
						break;
					case 4:
						String isAdmin = ConsoleIO.promptForInput("Enter the code: ", true);
						if (isAdmin.equals("PJMJ")) {
							String[] masterDeck = Tool.toStrArr(newDeck.getDeck());
							int masterCardNum = ConsoleIO.promptForMenuSelection(masterDeck, true);
							newDeck.getDeck().remove(masterCardNum - 1);
						} else {
							System.out.println("You are not authorized to delete master card data.");
						}

						break;
					case 5:
						int i = 0;
						for (Card card : newDeck.getDeck()) {
							i++;
							System.out.println(i + ".) " + card);

						}
						break;
					case 0:
						done = true;
						break;
					default:
						break;
					}

				}
				Tool.serialize(newDeck, "deck/" + edition + "/" + name + ".dc");
				Tool.serialize(master, "deck/" + edition + "/master.dc");
			} catch (FileNotFoundException e) {
				System.out.println("No such decks exist in this edition.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
