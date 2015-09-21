package englard.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import org.junit.Test;

public class ScrabbleDictionary {

	private HashSet<String> wordSet;

	public ScrabbleDictionary() throws FileNotFoundException {
		wordSet = new HashSet<String>();
		File aFile = new File("./us.dic");
		Scanner scanner = new Scanner(aFile);
		while (scanner.hasNext()) {
			wordSet.add(scanner.next());
		}
		scanner.close();

	}

	/**
	 * @return true if the dictionary contains the word, otherwise false.
	 */
	public boolean contains(String word) {
		return (wordSet.contains(word));
	}
}
