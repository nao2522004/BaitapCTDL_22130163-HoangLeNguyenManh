import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		// Scanner input = new Scanner(new File("data/hamlet.txt"));
		Scanner input = new Scanner(new File(fileName));

		while (input.hasNext()) {
			String word = input.next();
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		Set<Map.Entry<String, Integer>> entrys = map.entrySet();
		for (Map.Entry<String, Integer> entry : entrys) {
			System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		Map<String, Integer> newMap = new TreeMap<>(map);
		for(Map.Entry<String, Integer> entry : newMap.entrySet())
		System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
	}
	
	// Returns the number of distinct tokens in the file data/hamlet.txt or fit.txt
	public int countDistinct() {
	int count =0;
	Set<Map.Entry<String, Integer>> entries = map.entrySet();
	for(Map.Entry<String, Integer> entry : entries) {
		if(entry.getValue() == 1) {
			count++;
		}
	}
	return count;
	}


	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp wordCount = new MyWordCountApp();
		wordCount.loadData();
		System.out.println("Danh sách ban đầu " + wordCount.map);

		// test countUnique
		System.out.println("Count Unique: " + wordCount.countUnique());

		// test printWordCount
		System.out.print("Word count: ");
		wordCount.printWordCounts();

		// test printWordCountAL
		System.out.print("\nWord count alphabet: ");
		wordCount.printWordCountsAlphabet();
		
		// test countDistinct
		System.out.print("\nCount Distince: " + wordCount.countDistinct());
	}
}