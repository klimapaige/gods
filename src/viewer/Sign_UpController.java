package viewer;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sign_UpController {
	
	@FXML 
	private ComboBox<String> godChoices;
	static ObservableList<String> godTypeChoices = FXCollections.observableArrayList("War", "Death", "Love", "Water", "Messenger");
	
	@FXML
	private Button signUpButton;
	
	@FXML
	private TextField usernameBox;
	
	@FXML
	private PasswordField passwordBox;
	
	@FXML
	private Text yMU;
	
	@FXML
	private Text userName;
	
	@FXML
	private Text passWord;
	
	@FXML
	private Text godType;
	
	@FXML
	private Button backButton;

	@FXML
	public void initialize() throws IOException {
		
		godChoices.getItems().clear();
		godChoices.setItems(godTypeChoices);
		
		signUpButton.setOnAction((event) -> {
			if (!godChoices.getSelectionModel().isEmpty() && (!usernameBox.getText().isEmpty() && !passwordBox.getText().isEmpty())) {
				Parent loginScreen;
				try {
					System.out.println(usernameBox.getText());
					loginScreen = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
					
					Scene loginScene = new Scene(loginScreen, 960, 540);
					
					Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					
					loginStage.hide();
					
					loginStage.setMaximized(true);
					
					loginStage.setScene(loginScene);
					
					loginStage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				yMU.setText("Enter A Username and Password\nand chose a God Type");
			}
		});
		godChoices.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(godChoices.getValue());
			}
			
		});
		backButton.setOnAction((event) -> {
			Parent loginScreen;
			try {
				System.out.println(usernameBox.getText());
				loginScreen = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
				
				Scene loginScene = new Scene(loginScreen, 960, 540);
				
				Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				
				loginStage.hide();
				
				loginStage.setMaximized(true);
				
				loginStage.setScene(loginScene);
				
				loginStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
}
