package player;

import enums.GodType;
import enums.Mythology;

public class God {
	public final String godName;
	public final GodType type;
	public final Mythology mythology;

	public God(GodType god, Mythology mythology) {
		type = god;
		this.mythology = mythology;
		godName=findName();
	}

	public int ability() {
		return 0;
	}
	

	private String findName() {
		String name = "";
		switch (type) {
		case WATER:
			switch (mythology) {
			case GREEK:
				name = "Poseidon";
			case NORSE:
				name = "Egir";
			case ROMAN:
				name = "Neptune";
			case HINDU:
				name = "Varuna";
			case NEUMONT:
				name = "Kohler";
			}
		case WAR:
			switch (mythology) {
			case GREEK:
				name = "Ares";
			case NORSE:
				name = "Tyr";
			case ROMAN:
				name = "Mars";
			case HINDU:
				name = "Karttikeya";
			case NEUMONT:
				name = "Beatty";
			}
		case LOVE:
			switch (mythology) {
			case GREEK:
				name = "Aphrodite";
			case NORSE:
				name = "Freya";
			case ROMAN:
				name = "Neptune";
			case HINDU:
				name = "Rati";
			case NEUMONT:
				name = "Harrison";
			}
		case KING:
			switch (mythology) {
			case GREEK:
				name = "Zeus";
			case NORSE:
				name = "Odin";
			case ROMAN:
				name = "Jupiter";
			case HINDU:
				name = "Indra";
			case NEUMONT:
				name = "Krebs";
			}
		case DEATH:
			switch (mythology) {
			case GREEK:
				name = "Hades";
			case NORSE:
				name = "Hel";
			case ROMAN:
				name = "Pluto";
			case HINDU:
				name = "Yama";
			case NEUMONT:
				name = "Fletcher";
			}
		case MESSENGER:
			switch (mythology) {
			case GREEK:
				name = "Hermes";
			case NORSE:
				name = "Hermod";
			case ROMAN:
				name = "Mercury";
			case HINDU:
				name = "Agni";
			case NEUMONT:
				name = "JP";
			}

		}
		return name;
	}
}
