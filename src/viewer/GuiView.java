package viewer;

import java.util.ArrayList;

import card.Card;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import player.Player;

public class GuiView extends Application implements View{
	
	@Override
	public void showCard(Card card) {
		
	}
	
	@Override
	public void showStore() {
		
	}
	
	@Override
	public void reviewHand(Player player) {
		
	}
	
	@Override
	public int displayMenu(String[] options) {

		return 0;
	}

	@Override
	public ArrayList<String> getInformation() {
		
		ArrayList<String> info = new ArrayList<>();
		info.add(viewer.Sign_UpController.getUserName());
		info.add(viewer.Sign_UpController.getPassword());
		info.add(viewer.Sign_UpController.getGodtype());
		
		return info;
	}

	@Override
	public String loginScreen() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void launchGUI(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent loginScreen = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));

		Scene loginScene = new Scene(loginScreen, 960, 540);
		
		primaryStage.setTitle("Cards: War of The Gods!");
		
		primaryStage.setMaximized(true);
        
        primaryStage.setScene(loginScene);
        
        primaryStage.show();
		
	}
	
}
