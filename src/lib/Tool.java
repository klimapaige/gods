package lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Tool {

	public static String cleanString(String str) {
		char[] letterSubArr = str.toCharArray();
		ArrayList<Character> letters = new ArrayList<>();
		for (char c : letterSubArr) {
			letters.add(c);
		}
		StringBuilder sb = new StringBuilder();
		for (char c : letters) {
			if (c >= ' ') {
				sb.append(c);
			}
		}
		str = sb.toString();
		return str;
	}

	public static void serialize(Object o, String path) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(o);
		oos.close();
		fos.close();

	}

	public static Object deserialize(String path) throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		ois.close();
		fis.close();
		return o;
	}
}
