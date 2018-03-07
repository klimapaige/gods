package viewer;

import java.io.IOException;
import java.nio.file.Paths;

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

	Media md;
	MediaPlayer mp;
	
	@FXML
	public void initialize() throws IOException {
		
		md = new Media(Paths.get("src/app/Basically_hearthstone.mp4").toUri().toString());
		mp = new MediaPlayer(md);
		mediaView.setMediaPlayer(mp);
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
