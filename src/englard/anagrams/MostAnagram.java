package englard.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MostAnagram {

	public static void main(String[] args) {
		HashMap<String, Integer> letter = new HashMap<String, Integer>();
		String most = null;
		String otherMost = null;
		int biggest = 0, value;
		ArrayList<SortedAndUnsotedWord> dicWords = new ArrayList<SortedAndUnsotedWord>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("./us.dic"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNext()) {
			String unsortedWord = scanner.next().toLowerCase();
			char[] letters = unsortedWord.toCharArray();
			Arrays.sort(letters);
			String word = new String(letters);
			dicWords.add(new SortedAndUnsotedWord(unsortedWord, word)); // keep
																		// a
																		// list
																		// of
																		// all
																		// the
																		// words
			if (letter.get(word) == null) { // if no word with same letters add
											// new hashmap
				letter.put(word, 1);
			} else { // if there is already a word with these letters increment
						// hashmap

				letter.put(word, letter.get(word) + 1);
			}
			// update the bigest value counter
			value = letter.get(word);
			if (value == biggest) {
				// hold this map also
				otherMost = word;
			}
			if (value > biggest) {
				biggest = value;
				// keep the letters from the bigesst search
				most = word;
			}

		}

		// display results
		int counterOne =0;
		int counterTwo =0;
		System.out.printf("The biggest anagram is %s word  \n", biggest);
		for (SortedAndUnsotedWord word : dicWords) {
			if (word.getSortedWord().equals(most)) {
				System.out.print(++counterOne);
				System.out.println(word.getWord());
			} else if (word.getSortedWord().equals(otherMost)) {
				if(counterTwo ==0){
					System.out.printf("\n Another anagram with %s word \n", biggest);
				}
				System.out.print(++counterTwo);
				System.out.println(word.getWord());
			}
		}
		// System.out.println(most);
		// System.out.println(otherMost);

	}
}
