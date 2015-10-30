package englard.scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {

	private HashSet<String> wordSet;
	public static ScrabbleDictionary singleton;

	private ScrabbleDictionary() throws IOException {
		
		//TODO load from file
		
		wordSet = new HashSet<String>();
		BufferedReader in = new BufferedReader(new FileReader("./us.dic"));
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
	
	public static ScrabbleDictionary getInstance() throws IOException{
		if(singleton == null){
			singleton = new ScrabbleDictionary(); 
		}
		return singleton;
	}
}
