package card;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import enums.GodType;
import lib.ConsoleIO;
import lib.Tool;
import player.God;

public class Deck implements Serializable {

	private static final long serialVersionUID = -135494035811112623L;
	private ArrayList<Card> deck = new ArrayList<>();
	public final boolean isStarter;
	private GodType godType;
	private String name;

	public Deck(String name, boolean isStarter) {
		setName(name);
		this.isStarter = isStarter;
	}

	public Deck(God god) {
		this.isStarter = true;

	}

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
						c = Card.newCard();
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
						}
					}
					newDeck.addCard(c);
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
			boolean isStarter = false;
			try {
				master = (Deck) Tool.deserialize("deck/" + edition + "/master.dc");
				name = ConsoleIO.promptForInput("What are you naming your deck? ", false);
				Deck newDeck = (Deck) Tool.deserialize("deck/" + edition + "/" + name + ".dc");
				while (!done) {
					String[] prompt = { "Add Card", "Remove Card", "Remove Master Card (Requires admin code)",
							"View Cards" };
					int selection = ConsoleIO.promptForMenuSelection(prompt, true);
					switch (selection) {
					case 1:
						boolean newCard = ConsoleIO.promptForBool(
								"Do you want to add a new card to your new deck or one from the master deck? (n/m) ",
								"n", "m");
						Card c = null;
						if (newCard) {
							c = Card.newCard();
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
								}
							}
						}
						newDeck.addCard(c);
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

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public Card getCard(int index) {
		return deck.get(index);
	}

	public void shuffle() {
		int len = deck.size();
		Random rand = new Random();
		ArrayList<Card> newDeck = new ArrayList<>();
		for (int i = 0; i != len; len--) {
			newDeck.add(getDeck().get(rand.nextInt(len - 1)));
		}
	}

	public void addCard(Card c) {
		getDeck().add(c);
	}

	public Card pullCard() {
		int index = getDeck().size();
		Card c = getDeck().get(index);
		getDeck().remove(index);
		return c;
	}

	public Card pullCard(int index) {
		Card c = getDeck().get(index);
		getDeck().remove(index);
		return c;
	}

	public GodType getGodType() {
		return godType;
	}

	public void setGodType(GodType godType) {
		this.godType = godType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
