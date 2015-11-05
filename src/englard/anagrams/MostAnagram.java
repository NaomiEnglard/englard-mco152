package englard.anagrams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostAnagram {

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> letter = new HashMap<String, ArrayList<String>>();
		String most = null;
		String otherMost = null;
		int biggest = 0, value;
		ArrayList<String> dicWords = new ArrayList<String>();
		BufferedReader read = null;
		String line = null;
		try {
			read = new BufferedReader(new FileReader(("./us.dic")));
			line = read.readLine();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("problem reading in data");
		}
		while (line != null) {
			String unsortedWord = line.toLowerCase();
			dicWords.add(line); // word list
			char[] letters = unsortedWord.toCharArray();
			Arrays.sort(letters);
			String sortedLetters = new String(letters);
			if (letter.get(sortedLetters) == null) { // if no word with same
														// letters add
				// new hashmap
				ArrayList<String> words = new ArrayList<String>();
				words.add(line);
				letter.put(sortedLetters, words);
			} else { // if there is already a word with these letters increment
						// hashmap
				ArrayList<String> words = letter.get(sortedLetters);
				words.add(line);
				letter.replace(sortedLetters, words);
			}

			// update the bigest value counter
			value = letter.get(sortedLetters).size();
			if (value == biggest) {
				// hold this map also
				otherMost = sortedLetters;
			}
			if (value > biggest) {
				biggest = value;
				// keep the letters from the bigesst search
				most = sortedLetters;
			}
			// reset line
			try {
				line = read.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// display results

		System.out.printf("The biggest anagrams are %s word  \n", biggest);
		for (Map.Entry<String, ArrayList<String>> mapValue : letter.entrySet()) {
			if (mapValue.getKey().equals(most)) {
				System.out.print(mapValue.getValue());
			}
			if (mapValue.getKey().equals(otherMost)) {
				System.out.println(mapValue.getValue());
			}
		}

	}
}
