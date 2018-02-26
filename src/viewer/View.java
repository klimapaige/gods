package viewer;

import card.Card;
import player.Player;

public interface View {
	
	public void showCard(Card card);
	public void showStore();
	public void reviewHand(Player player);
	public int displayMenu();
	
}
