package viewer;

import java.io.IOException;

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

public class WinnerPage {
	@FXML
	private Button mainMenuButton;
	@FXML
	private Text winnerInfo;
	@FXML
	private ImageView winnerImage;
	
	static private Player winner;

	public static Player getWinner() {
		return winner;
	}

	public static void setWinner(Player win) {
		winner = win;
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
	public void initialize() throws IOException {
		String winnerImageSpot = location(getWinner());
		Image winImage = new Image(winnerImageSpot);
		winnerImage.setImage(winImage);
		winnerInfo.setText(winner.getGod().godName + ": God of " + winner.getGod().type
				+"\nYou got 50 credits!");
		mainMenuButton.setOnAction((event) -> {
			Parent mainMenueScreen;
			try {
				mainMenueScreen = FXMLLoader.load(getClass().getResource("Main_Menu.fxml"));

				Scene mainMenuScene = new Scene(mainMenueScreen, 960, 540);

				Stage mainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				mainMenuStage.hide();

				mainMenuStage.setMaximized(false);

				mainMenuStage.setScene(mainMenuScene);

				mainMenuStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
}
