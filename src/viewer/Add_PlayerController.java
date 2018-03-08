package viewer;

import java.io.IOException;

import controllers.Game;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ComboBox;

import javafx.scene.control.PasswordField;

public class Add_PlayerController {
	
	@FXML 
	private ComboBox<String> godChoices;
	public ObservableList<String> godTypeChoices = FXCollections.observableArrayList("Water", "War", "Love", "King", "Death", "Messenger");
	
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
	
	private static String username;
	private static String password;
	private static String godtype;
	
	public static String getUserName() {
		return username;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static String getGodtype() {
		return godtype;
	}
	

	@FXML
	public void initialize() throws IOException {
		
		godChoices.getItems().clear();
		godChoices.setItems(godTypeChoices);
		
		signUpButton.setOnAction((event) -> {
			username = usernameBox.getText();
			password = passwordBox.getText();
			godtype = godChoices.getValue().toUpperCase();
			Game.newPlayer();
			if (!godChoices.getSelectionModel().isEmpty() && (!usernameBox.getText().isEmpty() && !passwordBox.getText().isEmpty())) {
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
