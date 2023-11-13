import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = reader.readLine();

			if (line == null) {
				break;
			}
			StringTokenizer tokens = new StringTokenizer(line, " ");
			while (tokens.hasMoreTokens()) {
				String m = tokens.nextToken();
				if (tokens.hasMoreTokens()) {
					add(m, index);
				} else {
					add(m, -index);
				}
				index++;
			}
		}
		reader.close();
	}

	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		if (map.containsKey(word)) {
			ArrayList<Integer> values = map.get(word);
			values.add(position);
		} else {
			ArrayList<Integer> values = new ArrayList<>();
			values.add(position);
			map.put(word, values);
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> sortedMap = new TreeMap<>(map);
		for (Map.Entry<String, ArrayList<Integer>> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		int index = 1;
		int max = 0;
		for (String key : map.keySet()) {
			max += map.get(key).size();
		}
		while (index < max) {
			for (String key : map.keySet()) {
				if (map.get(key).contains(index)) {
					System.out.print(key + " ");
					index++;
				} else if (map.get(key).contains(-index)) {
					System.out.print(key + " ");
					System.out.println();
					index++;
				}
			}
		}
	}


	public String mostFrequentWord() {
		String mostFrequentWord = null;
		int maxFrequency = 0;

		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			int frequency = entry.getValue().size();
			if (maxFrequency < frequency) {
				maxFrequency = frequency;
				mostFrequentWord = entry.getKey() + "-" + entry.getValue();
			} else if (maxFrequency == frequency) {
				mostFrequentWord += entry.getKey() + "-" + entry.getValue();
			}
		}

		return mostFrequentWord;
	}

	public static void main(String[] args) throws IOException {
		TextAnalyzer ta = new TextAnalyzer();
		String fileName = "data/short.txt";
		// test load file
		System.out.println("Load file : \n");
		ta.load(fileName);
		System.out.println(ta.map);
		// test display word
		System.out.println("\nDisplayWords() :");
		ta.displayWords();
		// test display text
		System.out.println("\nDisplayText() :");
		ta.displayText();
		// test most frequent word
		System.out.println("\nMostFrequentWord() :");
		System.out.println(ta.mostFrequentWord());
	}
}
