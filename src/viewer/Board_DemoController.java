package viewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import card.Creature;
import controllers.Attack;
import controllers.Game;
import controllers.Match;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import player.Player;

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
	private Button startTurnButton;
	@FXML
	private Button endTurnButton;
	@FXML
	private Button declareAttackButton;
	@FXML
	private Button placeCardsButton;

	@FXML
	private Text whosPlaying1;
	@FXML
	private Text whosPlaying2;
	@FXML
	private Text whatGod1;
	@FXML
	private Text whatGod2;
	@FXML
	private Text player1Health;
	@FXML
	private Text player2Health;

	public int playerTurn;
	public int turnCount = 0;
	Player winner;

	public void updateField(Match m) {
		if (playerTurn % 2 == 1) {
			hboxField1.getChildren().removeAll(hboxField1.getChildren());
			for (int i = 0; i < m.board.getBattlefield1().length; ++i) {
				int temp = i;
				if (m.board.getBattlefield1()[i] != null && (m.board.getBattlefield1()[i] instanceof Creature)) {
					TextArea card = new TextArea();
					card.setWrapText(true);
					card.setId("card");
					card.setText(m.board.getBattlefield1()[i].getName() + "\n"
							+ ((Creature) m.board.getBattlefield1()[i]).getPower() + "\n"
							+ m.board.getBattlefield1()[i].getDescription());
					card.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							m.player1Attack[1] = temp;
							System.out.println("UpDate P1Attack" + Arrays.toString(m.player1Attack));
						}
					});
					hboxField1.getChildren().add(card);
				}
			}
		} else {
			hboxField2.getChildren().removeAll(hboxField2.getChildren());
			for (int i = 0; i < m.board.getBattlefield2().length; ++i) {
				int temp = i;
				if (m.board.getBattlefield2()[i] != null && (m.board.getBattlefield2()[i] instanceof Creature)) {
					TextArea card = new TextArea();
					card.setWrapText(true);
					card.setId("card");

					card.setText(m.board.getBattlefield2()[i].getName() + "\n"
							+ ((Creature) m.board.getBattlefield2()[i]).getPower() + "\n"
							+ m.board.getBattlefield2()[i].getDescription());
					card.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							m.player2Attack[1] = temp;
							System.out.println("UpDate P2Attack" + Arrays.toString(m.player2Attack));
						}
					});
					hboxField2.getChildren().add(card);
				}
			}
		}
	}

	public void updateHand(int playerTurn, Match m) {
		if (playerTurn % 2 == 1) {
			hboxHand1.getChildren().removeAll(hboxHand1.getChildren());
			for (int i = 0; i < m.board.getHand1().length; ++i) {
				int temp = i;
				if (m.board.getHand1()[i] != null) {
					TextArea card = new TextArea();
					card.setWrapText(true);
					card.setId("card");
					card.setText(m.board.getHand1()[i].getDescription() + "\n"
							+ m.board.getHand1()[i].getClass().getSimpleName());
					card.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							m.player1Selections.add(temp);
						}
					});
					hboxHand1.getChildren().add(card);
				}
			}
		} else {
			hboxHand2.getChildren().removeAll(hboxHand2.getChildren());
			for (int i = 0; i < m.board.getHand2().length; ++i) {
				int temp = i;
				if (m.board.getHand2()[i] != null) {
					TextArea card = new TextArea();
					card.setWrapText(true);
					card.setId("card");
					card.setText(m.board.getHand2()[i].getDescription() + "\n"
							+ m.board.getHand2()[i].getClass().getSimpleName());
					card.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							m.player2Selections.add(temp);
						}
					});
					hboxHand2.getChildren().add(card);
				}
			}
		}
	}

	public String location(Player p) {
		String location = "";
		switch (p.getGod().godName) {
		case "Beatty":
			location = "viewer/beatty.JPG";
			break;
		case "Fletcher":
			location = "viewer/fletcher.JPG";
			break;
		case "Kohler":
			location = "viewer/kohler.JPG";
			break;
		case "Krebs":
			location = "viewer/krebs.JPG";
			break;
		case "JP":
			location = "viewer/jp.JPG";
			break;
		case "Harrison":
			location = "viewer/harrison.JPG";
			break;
		}
		return location;
	}

	@FXML
	public void initialize() {

		Match m = new Match(Game.getPlayers().get(0), Game.getPlayers().get(1));
		String player1Image = location(m.player1);
		String player2Image = location(m.player2);

		Image image1 = new Image(player1Image);
		imageBox1.setImage(image1);
		Image image2 = new Image(player2Image);
		imageBox2.setImage(image2);

		whosPlaying1.setText(m.player1.getUsername());
		whosPlaying2.setText(m.player2.getUsername());
		whatGod1.setText(m.player1.getGod().godName + ": God of " + m.player1.getGod().type);
		whatGod2.setText(m.player2.getGod().godName + ": God of " + m.player2.getGod().type);
		player1Health.setText(m.player1.getHealth() + "");
		player2Health.setText(m.player2.getHealth() + "");

		whatGod1.setWrappingWidth(200);
		whatGod2.setWrappingWidth(200);

		imageBox1.setOnMouseClicked((event) -> {
			m.player1Attack[3] = 1;
			m.player2Attack[3] = 1;
			System.out.println("SOMC1 P1Attack" + Arrays.toString(m.player1Attack));
			System.out.println("SOMC1 P2Attack" + Arrays.toString(m.player2Attack));
		});
		imageBox2.setOnMouseClicked((event) -> {
			m.player1Attack[3] = 2;
			m.player2Attack[3] = 2;
			System.out.println("SOMC2 P1Attack" + Arrays.toString(m.player1Attack));
			System.out.println("SOMC2 P1Attack" + Arrays.toString(m.player2Attack));
		});

		m.start();
		int playerStartTurn = (int) (Math.random() * 2) + 1;// decides who goes first
		playerTurn = 1;

		startTurnButton.setOnAction((event) -> {
			System.out.println(m.player1Selections.toString());
			System.out.println(m.player2Selections.toString());
			System.out.println(Arrays.toString(m.board.getHand1()));
			System.out.println(Arrays.toString(m.board.getHand2()));
			System.out.println(Arrays.toString(m.board.getBattlefield1()));
			System.out.println(Arrays.toString(m.board.getBattlefield2()));
			for (int i = 0; i < 4; ++i) {
				m.player1Attack[i] = -1;
				m.player2Attack[i] = -1;
			}
			updateHand(playerTurn, m);
			placeCardsButton.setVisible(true);
			startTurnButton.setVisible(false);
		});

		placeCardsButton.setOnAction((event) -> {
			m.moveCards(playerTurn);
			System.out.println("ETB P1Select" + m.player1Selections.toString());
			System.out.println("ETB P2Select" + m.player2Selections.toString());
			System.out.println("ETB Hand1" + Arrays.toString(m.board.getHand1()));
			System.out.println("ETB Hand2" + Arrays.toString(m.board.getHand2()));
			System.out.println("ETB Battle1" + Arrays.toString(m.board.getBattlefield1()));
			System.out.println("ETB Battle2" + Arrays.toString(m.board.getBattlefield2()));

			updateHand(playerTurn, m);
			updateField(m);
			declareAttackButton.setVisible(true);
			placeCardsButton.setVisible(false);
		});

		declareAttackButton.setOnAction((event) -> {
			System.out.println("ETB P1Select" + m.player1Selections.toString());
			System.out.println("ETB P2Select" + m.player2Selections.toString());
			System.out.println("ETB Hand1" + Arrays.toString(m.board.getHand1()));
			System.out.println("ETB Hand2" + Arrays.toString(m.board.getHand2()));
			System.out.println("ETB Battle1" + Arrays.toString(m.board.getBattlefield1()));
			System.out.println("ETB Battle2" + Arrays.toString(m.board.getBattlefield2()));
			Attack round = m.turn(playerTurn, turnCount);
			// set the attack int arrays

			m.attackPhase(round, playerTurn);
			updateField(m);
			// draws cards based on the current cards in the hand
			player1Health.setText(m.player1.getHealth() + "");
			player2Health.setText(m.player2.getHealth() + "");
			if (playerTurn % 2 == 1) {
				m.board.drawCard(1, m.player1);
			} else {
				m.board.drawCard(2, m.player2);
			}

			endTurnButton.setVisible(true);
			declareAttackButton.setVisible(false);
		});

		endTurnButton.setOnAction((event) -> {
			System.out.println("ETB P1Select" + m.player1Selections.toString());
			System.out.println("ETB P2Select" + m.player2Selections.toString());
			System.out.println("ETB Hand1" + Arrays.toString(m.board.getHand1()));
			System.out.println("ETB Hand2" + Arrays.toString(m.board.getHand2()));
			System.out.println("ETB Battle1" + Arrays.toString(m.board.getBattlefield1()));
			System.out.println("ETB Battle2" + Arrays.toString(m.board.getBattlefield2()));
			if ((winner = m.checkWin()) != null) {
				Player lost = (winner == m.player1) ? m.player2 : m.player1;
				m.end(winner, lost);
				//sends it back to the main page but that breaks
//				Parent mainMenueScreen;
//				try {
//					mainMenueScreen = FXMLLoader.load(getClass().getResource("Main_Menu.fxml"));
//
//					Scene mainMenuScene = new Scene(mainMenueScreen, 960, 540);
//
//					Stage mainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//					mainMenuStage.hide();
//
//					mainMenuStage.setMaximized(false);
//
//					mainMenuStage.setScene(mainMenuScene);
//
//					mainMenuStage.show();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				//////////////////////////////////////////////////////
				///////Trying to add a winner page
				 WinnerPage.setWinner(winner);
				 Parent winnerScreen;
				 try {
				 winnerScreen = FXMLLoader.load(getClass().getResource("Winner.fxml"));
				
				 Scene winnerScene = new Scene(winnerScreen, 960, 540);
				
				 Stage winnerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				
				 winnerStage.hide();
				
				 winnerStage.setMaximized(true);
				
				 winnerStage.setScene(winnerScene);
				
				 winnerStage.show();
				 }catch (IOException e) {
					 e.printStackTrace();
				 }

			} else {
				hboxHand1.getChildren().removeAll(hboxHand1.getChildren());
				hboxHand2.getChildren().removeAll(hboxHand2.getChildren());
				m.player1Selections.clear();
				m.player2Selections.clear();
				startTurnButton.setVisible(true);
				endTurnButton.setVisible(false);
				if (playerTurn == 1) {
					playerTurn = 2;
				} else {
					playerTurn = 1;
				}
			}

		});

	}

}
