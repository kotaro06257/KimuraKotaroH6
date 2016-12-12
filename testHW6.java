package homework6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class testHW6 {

	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();

		try {
			BufferedReader br = new BufferedReader(new FileReader("HW6.1.txt"));
			try {
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}

					tree.insert(line);
				}
			} finally {
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(
				"Input: This sentence repeats words because a sentence that repeats words makes a good example sentence.");
		System.out.println("");
		String t = tree.toString().toLowerCase();
		String[] t2 = t.split("[(' '),.-]");
		HashMap<String, Integer> uniques = new HashMap<String, Integer>();
		for (String word : t2) {

			Integer existingCount = uniques.get(word);
			uniques.put(word, (existingCount == null ? 1 : (existingCount + 1)));

		}

		Set<Map.Entry<String, Integer>> uniqueSet = uniques.entrySet();

		for (Map.Entry<String, Integer> entry : uniqueSet) {

			System.out.println(entry.getKey() + " " + entry.getValue());

		}

	}

}
