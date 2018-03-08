package viewer;

import java.io.IOException;
import java.nio.file.Paths;

import controllers.Game;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Main_MenuController {
	@FXML
	private Text loadedUserName;
	@FXML
	private Button storeButton;
	@FXML
	private Button tradeButton;
	@FXML
	private Button playGameButton;
	@FXML
	private Button instructionButton;
	@FXML
	private Button quitButton;
	@FXML
	private MediaView mediaView;
	@FXML
	private GridPane gridPane;
	@FXML
	private Button saveButton;
	@FXML
	private Button newPlayerButton;

	Media md;
	MediaPlayer mp;

	public Text getLoadedUserName() {
		return loadedUserName;
	}

	@FXML
	public void initialize() throws IOException {

		loadedUserName.setText(Game.getPlayers().get(0).getUsername());

		md = new Media(Paths.get("src/viewer/Basically_hearthstone.mp4").toUri().toString());
		mp = new MediaPlayer(md);
		mediaView.setMediaPlayer(mp);
		saveButton.setOnAction((event) -> {
			Game.getPlayersHash().savePlayerList();
		});
		newPlayerButton.setOnAction((event) -> {
			Parent addPlayerScreen;
			try {
				addPlayerScreen = FXMLLoader.load(getClass().getResource("Add_Player.fxml"));

				Scene addPlayerScene = new Scene(addPlayerScreen, 960, 540);

				Stage addPlayerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				addPlayerStage.hide();

				addPlayerStage.setMaximized(true);

				addPlayerStage.setScene(addPlayerScene);

				addPlayerStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		playGameButton.setOnAction((event) -> {
			Parent playGameScreen;
			try {
				playGameScreen = FXMLLoader.load(getClass().getResource("Board_Demo.fxml"));

				Scene playGameScene = new Scene(playGameScreen, 960, 540);

				Stage playGameStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				playGameStage.hide();

				playGameStage.setMaximized(true);

				playGameStage.setScene(playGameScene);

				playGameStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		instructionButton.setOnAction((event) -> {
			Parent instructionScreen;
			try {
				instructionScreen = FXMLLoader.load(getClass().getResource("Instructions.fxml"));

				Scene instructionScene = new Scene(instructionScreen, 960, 540);

				Stage instructionStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				instructionStage.hide();

				instructionStage.setMaximized(true);

				instructionStage.setScene(instructionScene);

				instructionStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		quitButton.setOnAction((event) -> {
			Platform.exit();
		});

	}

	public void play(ActionEvent event) {
		mp.play();
	}

	public void pause(ActionEvent event) {
		mp.pause();
	}

	public void reload(ActionEvent event) {
		mp.seek(mp.getStartTime());
		mp.pause();
	}
}
