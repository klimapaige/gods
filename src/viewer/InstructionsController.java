package viewer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InstructionsController {
	@FXML
	private TextArea textArea;
	@FXML
	private Button backButton;
	@FXML
	private Pane paneWindow;

	@FXML
	public void initialize() throws IOException {
		backButton.setOnAction((event) -> {
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
