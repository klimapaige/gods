package viewer;

import card.Card;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	public String[] getInformation() {
		
		return null;
	}

	@Override
	public String loginScreen() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void launchGUI(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
		
	}
	
}
