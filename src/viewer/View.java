package viewer;

import java.util.ArrayList;

import card.Card;
import player.Player;

public interface View {
	
	public void showCard(Card card);
	public void showStore();
	public void reviewHand(Player player);
	public void launchGUI(String[] args);
	public int displayMenu(String[] options);
	public String loginScreen();
	public ArrayList<String> getInformation(); 
	// 0: Username, 1: God Type
}
