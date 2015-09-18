package englard.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.junit.Test;

public class ScrabbleDictionary {

	private ArrayList<String> wordList;

	public ScrabbleDictionary() throws FileNotFoundException {
		wordList = new ArrayList<String>();
		File aFile = new File("./us.dic");
		Scanner scanner = new Scanner(aFile);
		while (scanner.hasNext()) {
			wordList.add(scanner.next());
		}
		scanner.close();
		// sort list
		Collections.sort(wordList);

	}

	
	/**
	 * @return true if the dictionary contains the word, otherwise false.
	 */
	public boolean contains(String word) {
		// reg search - no need to sort
		/*
		 * for (int i = 0; i < wordList.size(); i++) { if
		 * (wordList.get(i).equalsIgnoreCase(word)) { return true; }
		 */
		// binary search - quicker but for the first one its longer because you
		// need to sort the list
		int first = 0;
		int last = wordList.size();

		while (first < last) {
			int mid = (first + last) / 2;
			if (word.compareTo(wordList.get(mid)) < 0) {
				last = mid;
			} else if (word.compareTo(wordList.get(mid)) > 0) {
				first = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}

}
