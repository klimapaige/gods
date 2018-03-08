package player;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

import controllers.Game;
import enums.GodType;
import lib.Tool;

@SuppressWarnings("serial")
public class Players implements Serializable {

	private final long serialVersionUID = 877216857619279738L;
	private HashMap<String, Player> playerList;
	private String filePath;
	
	public Players(boolean newPlayerList, String filePath) {
		if(newPlayerList) {
			setPlayerList(new HashMap<String, Player>());
			setFilePath(filePath);
		}else {
			try {
				Players p = (Players) Tool.deserialize(filePath);
				this.setPlayerList(p.getPlayerList());
				this.setFilePath(p.getFilePath());
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addPlayer(Player player) {
		getPlayerList().put(player.getUsername(), player);
	}

	public Player loadPlayer(String username) {
		Player loaded = null;
		loaded = getPlayerList().get(username);
		return loaded;
	}

	public boolean checkPlayerLogin(String username, String password) {
		boolean load = false;
		String[] potentialUsernames = new String[getPlayerList().size()];
		getPlayerList().keySet().toArray(potentialUsernames);
		
		for (int i = 0; i < potentialUsernames.length && load == false; i++) {
			if (username.equals(potentialUsernames[i])) {
				if (password.equals(getPlayerList().get(username).getPassword())) {
					// Both are valid
					System.out.println("hello");
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

	public HashMap<String, Player> getPlayerList() {
		return playerList;
	}
	
	public void savePlayerList() {
		try {
			Tool.serialize(this, getFilePath());
		} catch (IOException e) {
			System.out.println("Unable to save player list.");
		}
	}

	public void setPlayerList(HashMap<String, Player> playerList) {
		this.playerList = playerList;
//		System.out.println("Added");
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
