
import java.io.FileNotFoundException;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> newList = new ArrayList<>();
		for (String w : words) {
			WordCount wc = new WordCount(w, count(w));
			if (!newList.contains(wc)) {
				newList.add(wc);
			}
		}
		return newList;
	}

	private int count(String word) {
		int count = 0;
		for (String oWord : words) {
			if (word.equals(oWord)) {
				count++;
			}
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> newSet = new HashSet<>();
		for (WordCount word : getWordCounts()) {
			if (word.getCount() == 1) {
				newSet.add(word.getWord());
			}
		}
		return newSet;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> newSet = new HashSet<>();
		for (WordCount word : getWordCounts()) {
			newSet.add(word.getWord());
		}

		return newSet;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
	    Comparator<WordCount> compareTo = new Comparator<WordCount>() {
	        @Override
	        public int compare(WordCount o1, WordCount o2) {
	            return o1.getCount() - o2.getCount();
	        }
	    };

	    // Sử dụng một TreeSet với Comparator để sắp xếp theo count tăng dần
	    Set<WordCount> sortedSet = new TreeSet<>(compareTo);

	    // Lấy danh sách các WordCount ban đầu từ getWordCounts()
	    List<WordCount> originalWordCounts = getWordCounts();

	    // Duyệt danh sách ban đầu
	    for (WordCount wordCount : originalWordCounts) {
	        sortedSet.add(wordCount);
	    }

	    // In ra kết quả
	    for (WordCount wordCount : sortedSet) {
	        System.out.println(wordCount.getWord() + " - " + wordCount.getCount());
	    }

	    return sortedSet;
	}


	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Comparator<WordCount> compareTo = new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o1.getCount() - o2.getCount();
			}
		};
		Set<WordCount> newSet = new TreeSet<>(compareTo.reversed());
		newSet.addAll(getWordCounts());
		return newSet;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> newSet = new HashSet<>();
		for (String word : words) {
			if (!word.startsWith(pattern)) {
				newSet.add(word);
			}
		}
		return newSet;
	}

	public static void main(String[] args) {
		MyWordCount wordCounter = new MyWordCount();

		// test getWordCount
		List<WordCount> wordCounts = wordCounter.getWordCounts();
		System.out.println("\nWord Counts:");
		for (WordCount wordCount : wordCounts) {
			System.out.println(wordCount.toString());
		}

		// test getUniqueWords
		Set<String> wordCounts1 = wordCounter.getUniqueWords();
		System.out.println("\nUnique Word Count:");
		for (String wordCount : wordCounts1) {
			System.out.println(wordCount);
		}

		// test getUniqueWords
		Set<String> wordCounts2 = wordCounter.getDistinctWords();
		System.out.println("\nDistinct Word Count:");
		for (String wordCount : wordCounts2) {
			System.out.println(wordCount);
		}

		// test printWordCount
		Set<WordCount> wordCounts4 = wordCounter.printWordCounts();
		System.out.println("\nPrintWordCount:");
		for (WordCount wordCount : wordCounts4) {
			System.out.println(wordCount.toString());
		}

		// test exportWordCountsByOccurence
		Set<WordCount> wordCounts5 = wordCounter.exportWordCountsByOccurence();
		System.out.println("\nexportWordCountsByOccurence:");
		for (WordCount wordCount : wordCounts5) {
			System.out.println(wordCount.toString());
			

		}
		
		// test exportWordCountsByOccurence
		Set<String> wordCounts6 = wordCounter.filterWords("D");
		System.out.println("\nfilterWords:");
		for (String wordCount : wordCounts6) {
			System.out.println(wordCount.toString());
			

		}
		
		
	}

}
