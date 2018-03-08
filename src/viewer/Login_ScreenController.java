package viewer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import controllers.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import player.Player;
import player.Players;
import javafx.scene.control.PasswordField;

public class Login_ScreenController {
	@FXML
	private TextField usernameBox;
	@FXML
	private Button loginButton;
	@FXML
	private PasswordField passwordBox;
	@FXML
	private Button signUpButton;
	@FXML
	private Button loadButton;

	private String loadedFile;

	@FXML
	public void initialize() throws IOException {
		signUpButton.setOnAction((event) -> {
			Parent signUpScreen;
			try {
				signUpScreen = FXMLLoader.load(getClass().getResource("Sign_Up.fxml"));

				Scene signUpScene = new Scene(signUpScreen, 960, 540);

				Stage signUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				signUpStage.hide();

				signUpStage.setMaximized(true);

				signUpStage.setScene(signUpScene);

				signUpStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		loadButton.setOnAction((event) -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open C:WotG");
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Player File", "*.pl"),
					new ExtensionFilter("Deck File", "*.dc"));
			File selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

			System.out.println(selectedFile);

			loadedFile = selectedFile.toString();

			Game.setPlayerHashOld(loadedFile);
			// System.out.println(Game.getPlayersHash().getPlayerList().keySet().toString());
		});
		loginButton.setOnAction((event) -> {

			if (!usernameBox.getText().isEmpty() && !passwordBox.getText().isEmpty()) {
				if (Game.getPlayersHash().checkPlayerLogin(usernameBox.getText(), passwordBox.getText())) {

					Parent mainMenuScreen;
					try {
						mainMenuScreen = FXMLLoader.load(getClass().getResource("Main_Menu.fxml"));

						Scene mainMenuScene = new Scene(mainMenuScreen, 960, 540);

						Stage mainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

						mainMenuStage.hide();

						mainMenuStage.setFullScreen(true);

						mainMenuStage.setScene(mainMenuScene);

						mainMenuStage.show();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("oops");
				}
			} else {
				System.out.println("original oops");
			}

		});
	}

}
