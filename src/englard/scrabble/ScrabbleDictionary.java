package englard.scrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import org.junit.Test;

public class ScrabbleDictionary {

	private HashSet<String> wordSet;

	public ScrabbleDictionary() throws IOException {
		wordSet = new HashSet<String>();
		File aFile = new File("./us.dic");
		BufferedReader in = new BufferedReader(new FileReader("aFile"));
		String word;

		while ((word = in.readLine()) != null) {
			wordSet.add(word);

		}
		in.close();

	}

	/**
	 * @return true if the dictionary contains the word, otherwise false.
	 */
	public boolean contains(String word) {
		return (wordSet.contains(word));
	}
}
