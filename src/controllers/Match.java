package controllers;

import java.util.ArrayList;

import card.Board;
import card.Card;
import card.Deck;
import player.Player;
import viewer.View;

public class Match {
	public Player player1;
	public Player player2;
	public Board board = new Board();
	public ArrayList<Integer> player1Selections = new ArrayList<>();
	public ArrayList<Integer> player2Selections = new ArrayList<>();
	public int[] player1Attack = new int[4];
	public int[] player2Attack = new int[4];

	public Match(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void runGame() {
		// start();
		// int turnCount = 0;
		// int playerTurn = (int) (Math.random() * 2);//decides who goes first
		// Player winner;
		// //runs until there is a winner
		// while ((winner = checkWin()) == null) {
		// turnCount++;
		// turn(playerTurn, turnCount);
		// }
		// Player lost = winner==player1?player2:player1;
		//
		//
		// end(winner,lost);
	}

	public void start() {
		// each player gets 5 cards drawn for each of their hands
		// onto the board
		board.drawFirstCards(player1, player2);
	}

	// the code running a round
	public Attack turn(int playerTurn, int turnCount) {
		int mana = turnCount > 10 ? 10 : turnCount;

		Player attacker, attackie;
		Card[] myHand, myBattlefeild, theirBattlefeild;
		// decides who is the attacker and who is being attacked
		if (playerTurn % 2 == 1) {
			playerTurn = 1;
			attacker = player1;
			attackie = player2;
			myHand = board.getHand1();
			myBattlefeild = board.getBattlefield1();
			theirBattlefeild = board.getBattlefield2();
		} else {
			playerTurn = 2;
			attacker = player2;
			attackie = player1;
			myHand = board.getHand1();
			myBattlefeild = board.getBattlefield2();
			theirBattlefeild = board.getBattlefield1();
		}
		attacker.setMana(mana);// sets mana for the card selection phase
		// gui view is supposed to return an array of ints representing the
		// indices of hand

		// sets up the class for the attack
		Attack round = new Attack(player1, player2, myHand, myBattlefeild, theirBattlefeild);
		return round;
	}

	public void moveCards(int playerTurn) {
		if (playerTurn == 1) {
			board.moveCards(playerTurn, player1Selections);
		} else {
			board.moveCards(playerTurn, player2Selections);
		}
	}

	public Player checkWin() {
		Player win = null;
		// decides if there is a winner based on health
		// if tie, then the players' health gets set back to 10 and they
		// continue the round
		if (player1.getHealth() <= 0 && player2.getHealth() > 0) {
			win = player2;
		} else if (player2.getHealth() <= 0 && player1.getHealth() > 0) {
			win = player1;
		} else if (player2.getHealth() <= 0 && player1.getHealth() <= 0) {
			player1.setHealth(10);
			player2.setHealth(10);
		}
		return win;
	}

	public void attackPhase(Attack round, int playerTurn) {

		int[] choices;

		boolean continueGame = false;
		
			continueGame = false;
			// sets the player's choices for attack
			if (playerTurn == 1) {
				choices = player1Attack;
			} else {
				choices = player2Attack;
			}
			// checks if there was any choices made, if not the rounds
			for (int k : choices) {
				if (k > -1) {
					continueGame = true;
				}
			}
			if (continueGame) {
				round.attackRound(choices);
			}

	}

	public void end(Player win, Player lost) {
		// win gets 50 credits added
		win.setCredit(win.getCredit() + 50);
		// lost gets 10 credit added
		lost.setCredit(lost.getCredit() + 10);
	}

}
