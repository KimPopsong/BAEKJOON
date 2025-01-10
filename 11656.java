import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		ArrayList<String> dict = new ArrayList<>();

		for (int i = 0; i < word.length(); i++) {
			dict.add(word.substring(i));
		}

		Collections.sort(dict);

		for (String d : dict) {
			System.out.println(d);
		}
	}
}
