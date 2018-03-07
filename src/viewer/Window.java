package viewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Application{
	
	public static void openApp(String[] args) {
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
