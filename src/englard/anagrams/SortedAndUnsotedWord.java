package englard.anagrams;

public class SortedAndUnsotedWord {
	private String word;
	private String sortedWord;
	
	public SortedAndUnsotedWord(String unsorted, String sorted){
		this.word = unsorted;
		this.sortedWord = sorted;
	}

	public String getWord() {
		return word;
	}

	public String getSortedWord() {
		return sortedWord;
	}

}
