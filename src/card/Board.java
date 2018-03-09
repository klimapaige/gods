package card;

import java.util.ArrayList;

import player.Player;

public class Board {

	Deck discardDeck1, discardDeck2;
	Card[] hand1 = new Card[8];
	Card[] hand2 = new Card[8];
	Card[] battlefield1 = new Card[8];
	Card[] battlefield2 = new Card[8];

	public Board() {
		discardDeck1 = new Deck("Discard deck 1", false);
		discardDeck2 = new Deck("Discard deck 2", false);
	}

	public Deck getDiscardDeck1() {
		return discardDeck1;
	}

	public void setDiscardDeck1(Deck discardDeck1) {
		this.discardDeck1 = discardDeck1;
	}

	public Deck getDiscardDeck2() {
		return discardDeck2;
	}

	public void setDiscardDeck2(Deck discardDeck2) {
		this.discardDeck2 = discardDeck2;
	}

	public Card[] getHand1() {
		return hand1;
	}

	public void setHand1(Card[] hand1) {
		this.hand1 = hand1;
	}

	public Card[] getHand2() {
		return hand2;
	}

	public void setHand2(Card[] hand2) {
		this.hand2 = hand2;
	}

	public Card[] getBattlefield1() {
		return battlefield1;
	}

	public void setBattlefield1(Card[] battlefeild1) {
		this.battlefield1 = battlefeild1;
	}

	public Card[] getBattlefield2() {
		return battlefield2;
	}

	public void setBattlefield2(Card[] battlefeild2) {
		this.battlefield2 = battlefeild2;
	}

	public void drawFirstCards(Player player1, Player player2) {
		for (int i = 0; i < 5; i++) {
			hand1[i] = player1.getMatchDeck().pullCard();
			hand2[i] = player2.getMatchDeck().pullCard();
		}

	}

	public void drawCard(int playerNumber, Player player) {
		if (playerNumber == 1) {
			if (!player.getMatchDeck().getDeck().isEmpty()) {
				int cards = 8;
				for (int i = 0; i < 8; i++) {
					if (hand1[i] == null) {
						cards--;
					}
				}
				if (cards < 5) {
					for (int i = 0; i < 8 && cards < 5 &&!player.getMatchDeck().getDeck().isEmpty(); i++) {
						if (hand1[i] == null) {
							cards++;
							hand1[i] = player.getMatchDeck().pullCard();
						}
					}
				} else if (cards >= 5 && cards < 8) {
					boolean addedCard = false;
					for (int i = 0; i < 8 && !addedCard; i++) {
						if (hand1[i] == null) {
							addedCard = true;
							hand1[i] = player.getMatchDeck().pullCard();
						}
					}
				} else if (cards == 8) {
					// Ask user if they want to switch a single card, else nothing
					// if user says yes, ask which card to discard
				}
			}

		} else {
			if (!player.getMatchDeck().getDeck().isEmpty()) {
				int cards = 8;
				for (int i = 0; i < 8; i++) {
					if (hand2[i] == null) {
						cards--;
					}
				}
				if (cards < 5) {
					for (int i = 0; i < 8 && cards < 5; i++) {
						if (hand2[i] == null) {
							cards++;
							hand2[i] = player.getMatchDeck().pullCard();
						}
					}
				} else if (cards >= 5 && cards < 8) {
					boolean addedCard = false;
					for (int i = 0; i < 8 && !addedCard; i++) {
						if (hand2[i] == null) {
							addedCard = true;
							hand2[i] = player.getMatchDeck().pullCard();
						}
					}
				} else if (cards == 8) {
					// Ask user if they want to switch a single card, else nothing
					// if user says yes, ask which card to discard
				}
			}

		}
	}

	public void moveCards(int playerNumber, ArrayList<Integer> cardChoices) {
		if (cardChoices.size() > 0) {
			if (playerNumber == 1) {
				for (int handIndex : cardChoices) {
					boolean placed = false;
					for (int i = 0; i < battlefield1.length && !placed; i++) {
						if (battlefield1[i] == null) {
							battlefield1[i] = hand1[handIndex];
							hand1[handIndex]=null;
							placed = true;
						}
					}
				}
			} else {
				for (int handIndex : cardChoices) {
					boolean placed = false;
					for (int i = 0; i < battlefield2.length && !placed; i++) {
						if (battlefield2[i] == null) {
							battlefield2[i] = hand2[handIndex];
							hand2[handIndex]=null;
							placed = true;
						}
					}
				}
			}
		}
	}

}
