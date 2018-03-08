package player;

import java.io.Serializable;

import enums.GodType;
import enums.Mythology;

public class God implements Serializable {

	private static final long serialVersionUID = -539128161609383270L;
	public final String godName;
	public final GodType type;
	public final Mythology mythology;

	public God(GodType god, Mythology mythology) {
		type = god;
		this.mythology = mythology;
		godName = findName();
	}

	public int ability() {
		return 0;
	}

	private String findName() {
		String name = "";
		switch (type) {
		case WATER:
			switch (mythology) {
//			case GREEK:
//				name = "Poseidon";
//				break;
//			case NORSE:
//				name = "Egir";
//				break;
//			case ROMAN:
//				name = "Neptune";
//				break;
//			case HINDU:
//				name = "Varuna";
//				break;
			case NEUMONT:
				name = "Kohler";
				break;
			}
		case WAR:
			switch (mythology) {
//			case GREEK:
//				name = "Ares";
//				break;
//			case NORSE:
//				name = "Tyr";
//				break;
//			case ROMAN:
//				name = "Mars";
//				break;
//			case HINDU:
//				name = "Karttikeya";
//				break;
			case NEUMONT:
				name = "Beatty";
				break;
			}
		case LOVE:
			switch (mythology) {
//			case GREEK:
//				name = "Aphrodite";
//				break;
//			case NORSE:
//				name = "Freya";
//				break;
//			case ROMAN:
//				name = "Venus";
//				break;
//			case HINDU:
//				name = "Rati";
//				break;
			case NEUMONT:
				name = "Harrison";
				break;
			}
		case KING:
			switch (mythology) {
//			case GREEK:
//				name = "Zeus";
//				break;
//			case NORSE:
//				name = "Odin";
//				break;
//			case ROMAN:
//				name = "Jupiter";
//				break;
//			case HINDU:
//				name = "Indra";
//				break;
			case NEUMONT:
				name = "Krebs";
				break;
			}
		case DEATH:
			switch (mythology) {
//			case GREEK:
//				name = "Hades";
//				break;
//			case NORSE:
//				name = "Hel";
//				break;
//			case ROMAN:
//				name = "Pluto";
//				break;
//			case HINDU:
//				name = "Yama";
//				break;
			case NEUMONT:
				name = "Fletcher";
				break;
			}
		case MESSENGER:
			switch (mythology) {
//			case GREEK:
//				name = "Hermes";
//				break;
//			case NORSE:
//				name = "Hermod";
//				break;
//			case ROMAN:
//				name = "Mercury";
//				break;
//			case HINDU:
//				name = "Agni";
//				break;
			case NEUMONT:
				name = "JP";
				break;
			}

		}
		return name;
	}

}
