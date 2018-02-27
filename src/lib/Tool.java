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
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
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
	
	public static String[] toStrArr(Object[] arr) {
		int i  = 0;
		String[] strArr = new String[arr.length];
		for(Object o : arr) {
			strArr[i] = o.toString();
			i++;
		}
		return strArr;
	}
	
	public static String[] toStrArr(ArrayList<?> arrList) {
		int i  = 0;
		String[] strArr = new String[arrList.size()];
		for(Object o : arrList) {
			strArr[i] = o.toString();
			i++;
		}
		return strArr;
	}
	
	public static ArrayList<String> toStrArrList(Object[] arr) {
		ArrayList<String> strArrList = new ArrayList<>();
		for(Object o : arr) {
			strArrList.add(o.toString());
		}
		return strArrList;
	}
	
	public static ArrayList<String> toStrArrList(ArrayList<?> arrList) {
		ArrayList<String> strArrList = new ArrayList<>();
		for(Object o : arrList) {
			strArrList.add(o.toString());
		}
		return strArrList;
	}
}
