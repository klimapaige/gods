package player;

import java.io.Serializable;
import java.util.HashMap;

import enums.GodType;

public class Players implements Serializable {

	private static final long serialVersionUID = 877216857619279738L;
	private static HashMap<String, Player> playerList = new HashMap<>();

	public static void newPlayer(String username, String password, GodType godtype) {
		Player newPlayer = new Player(username, password, godtype);
		getPlayerList().put(username, newPlayer);
	}

	public static Player loadPlayer(String username) {
		Player loaded = null;
		loaded = getPlayerList().get(username);
		return loaded;
	}

	public static boolean checkPlayerLogin(String username, String password) {
		boolean load = false;
		String[] potentialUsernames = new String[getPlayerList().size()];
		getPlayerList().keySet().toArray(potentialUsernames);
		for (int i = 0; i < 0 && load == false; i++) {
			if (username.equals(potentialUsernames[i])) {
				if (password.equals(getPlayerList().get(username).getPassword())) {
					// Both are valid
					load = true;
				} else {
					// Password is invalid
					load = false;
				}
			} else {
				// Username is invalid
				load = false;
			}
		}

		return load;
	}

	public static HashMap<String, Player> getPlayerList() {
		return playerList;
	}

	public static void setPlayerList(HashMap<String, Player> playerList) {
		Players.playerList = playerList;
	}

}
