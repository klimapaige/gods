package controllers;

import java.util.ArrayList;

import card.Board;
import card.Card;
import card.Deck;
import player.Player;
import viewer.View;

public class Match {
	private Player player1;
	private Player player2;
	private Board board = new Board();
	View view;

	public Match(Player player1, Player player2, View view) {
		this.player1 = player1;
		this.player2 = player2;
		this.view = view;
	}

	public void runGame() {
		start();
		int turnCount = 0;
		int playerTurn = (int) (Math.random() * 2);//decides who goes first
		Player winner;
		//runs until there is a winner
		while ((winner = checkWin()) == null) {
			turnCount++;
			turn(playerTurn, turnCount);
		}
		Player lost = winner==player1?player2:player1;
		
	
		end(winner,lost);
	}

	public void start() {
		//each player gets 5 cards drawn for each of their hands
		//onto the board
		board.drawFirstCards(player1, player2);
	}
	
	//the code running a round 
	public void turn(int playerTurn, int turnCount) {
		int mana = turnCount > 10 ? 10 : turnCount;
		//code for each person's turn
		for (int i = 0; i < 2; i++) {
			Player attacker, attackie;
			Card[] myHand, myBattlefeild, theirBattlefeild;
			//decides who is the attacker and who is being attacked
			if (playerTurn % 2 == 1) {
				playerTurn = 1;
				attacker = player1;
				attackie = player2;
				myHand = board.getHand1();
				myBattlefeild = board.getBattlefeild1();
				theirBattlefeild = board.getBattlefeild2();
			} else {
				playerTurn = 2;
				attacker = player2;
				attackie = player1;
				myHand = board.getHand1();
				myBattlefeild = board.getBattlefeild2();
				theirBattlefeild = board.getBattlefeild1();
			}
			attacker.setMana(mana);//sets mana for the card selection phase
			//gui view is supposed to return an array of ints representing the 
			//indices of hand
			board.moveCards(playerTurn, new int[0]);
			//sets up the class for the attack
			Attack round = new Attack(attacker, attackie, myHand, myBattlefeild, theirBattlefeild);
			attackPhase(round);
			//draws cards based on the current cards in the hand
			board.drawCard(playerTurn, attacker);
			playerTurn++;
		}
	}

	public Player checkWin() {
		Player win = null;
		//decides if there is a winner based on health
		//if tie, then the players' health gets set back to 10 and they 
		//continue the round
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

	public void attackPhase(Attack round) {

		int[] choices = new int[4];
		// this is temporary until we get a choices from the gui application
		for (int j = 0; j < choices.length; j++) {
			choices[j] = -1;
		}
		
		boolean continueGame = false;
		do {
			continueGame = false;
			// getChoices from view
			
			//checks if there was any choices made, if not the rounds 
			for (int k : choices) {
				if (k > -1) {
					continueGame = true;
				}
			}
			if (continueGame) {
				round.attackRound(choices);
			}
		} while (continueGame);

	}


	public void end(Player win,Player lost) {
		//win gets 50 credits added
		win.setCredit(win.getCredit()+50);
		//lost gets 10 credit added
		lost.setCredit(lost.getCredit()+10);
		
		//display the winner
	}

}
