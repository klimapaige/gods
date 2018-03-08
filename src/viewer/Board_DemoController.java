package viewer;

import controllers.Attack;
import controllers.Game;
import controllers.Match;
import javafx.fxml.FXML;

import javafx.scene.layout.HBox;
import player.Player;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class Board_DemoController {
	@FXML
	private ImageView imageBox1;
	@FXML
	private HBox hboxField1;
	@FXML
	private HBox hboxHand1;
	@FXML
	private ImageView imageBox2;
	@FXML
	private HBox hboxField2;
	@FXML
	private HBox hboxHand2;

	@FXML
	public void initialize() {

		Match m = new Match(Game.getPlayers().get(0), Game.getPlayers().get(1));

		imageBox1.setOnMouseClicked((event) -> {
			m.player1Attack[3] = 1;
		});
		imageBox2.setOnMouseClicked((event) -> {
			m.player1Attack[3] = 2;
		});

		m.start();
		int turnCount = 0;
		int playerTurn = (int) (Math.random() * 2);// decides who goes first
		Player winner;
		// runs until there is a winner
		while ((winner = m.checkWin()) == null) {
			turnCount++;
			if (playerTurn % 2 == 1) {
				for (int i = 0; i < m.board.getHand1().length && m.board.getHand1()[i] != null; ++i) {
					int temp = i;
					TextArea card = new TextArea();
					card.setText(m.board.getHand1()[i].getDescription());
					card.setOnMouseClicked((event) -> {
						m.player2Selections.add(temp);
					});
					hboxHand1.getChildren().add(card);
				}
			} else {
				for (int i = 0; i < m.board.getHand2().length && m.board.getHand2()[i] != null; ++i) {
					int temp = i;
					TextArea card = new TextArea();
					card.setText(m.board.getHand2()[i].getDescription());
					card.setOnMouseClicked((event) -> {
						m.player2Selections.add(temp);
					});
					hboxHand2.getChildren().add(card);
				}
			}
			m.moveCards(playerTurn);
			if (playerTurn % 2 == 1) {
				for (int i = 0; i < m.board.getBattlefield1().length && m.board.getBattlefield1()[i] != null; ++i) {
					int temp = i;
					TextArea card = new TextArea();
					card.setText(m.board.getBattlefield1()[i].getDescription());
					card.setOnMouseClicked((event) -> {
						m.player1Attack[1] = temp;
					});
					hboxField1.getChildren().add(card);
				}
			} else {
				for (int i = 0; i < m.board.getBattlefield2().length && m.board.getBattlefield2()[i] != null; ++i) {
					int temp = i;
					TextArea card = new TextArea();
					card.setText(m.board.getBattlefield2()[i].getDescription());
					card.setOnMouseClicked((event) -> {
						m.player2Attack[1] = temp;
					});
					hboxField2.getChildren().add(card);
				}
			}
			Attack round = m.turn(playerTurn, turnCount);

			m.attackPhase(round, playerTurn);
			// draws cards based on the current cards in the hand
			if (playerTurn % 2 == 1) {
				m.board.drawCard(playerTurn, m.player1);
			} else {
				m.board.drawCard(playerTurn, m.player2);
			}
			playerTurn++;

			m.turn(playerTurn, turnCount);
			round = m.turn(playerTurn, turnCount);
			// set the attack int arrays
			m.attackPhase(round, playerTurn);
			// draws cards based on the current cards in the hand
			if (playerTurn % 2 == 1) {
				m.board.drawCard(playerTurn, m.player1);
			} else {
				m.board.drawCard(playerTurn, m.player2);
			}
			playerTurn++;
		}
		Player lost = winner == m.player1 ? m.player2 : m.player1;

		m.end(winner, lost);
		// display the winner
	}

}
