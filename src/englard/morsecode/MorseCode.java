package englard.morsecode;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class MorseCode {
	private String codedMessage;
	private String decodedMessage;
	private HashMap<String, String> map;

	public MorseCode() {
		// add all values in enum to the map
		map = new HashMap<String, String>();
		for (MorseCodeEnum mCE : MorseCodeEnum.values()) {
			String letter = mCE.toString();
			String code = mCE.getCode();
			this.map.put(letter, code); // add the letter maped to its morse
										// code equivlant
			this.map.put(code, letter); // add the code map it to its letter
		}
	}

	public String encode(String message) {
		message = message.toUpperCase(); // convert message to upercase since
											// the mosrse code enum values are
											// upercase
		StringBuilder builder = new StringBuilder();
		// create an array to hold each letter of the message
		char[] messageList = message.toCharArray();
		// loop through each letter
		for (int i = 0; i < messageList.length; i++) {
			// the space between words gets converted into three spaces
			// in the morseCoe message
			if (messageList[i] == ' ') {
				builder.append("  "); // only two spaces since the third will
				// be put after the previous letter

			}
			// if the character is not a space get the morse code version and
			// then put a single space after to seperate letters
			else {
				// covert the letter from char to string and get its code
				String codedLetter = map.get(String.valueOf(messageList[i]));
				builder.append(codedLetter);
				// if not that last letter add a space after the letter
				if (i != (message.length() - 1)) {
					builder.append(" ");
				}
			}
		}
		return builder.toString();

	}

	public String decode(String code) {
		StringBuilder builder = new StringBuilder();
		// create a string array to hold each "letter" of the code
		String[] messageList = code.split(" ");
		for (int i = 0; i < messageList.length; i++) { // translate each letter
			// find which letter should be used instead of a morse code string
			if (messageList[i].equals("")) { // two spaces since splitter used
												// one as a deliminator
				builder.append(" ");
				i++; // skip the next space since three spaces come together

			} else {
				builder.append(map.get(messageList[i]));
			}

		}

		return builder.toString();

	}

	public static void main(String[] args) {
		MorseCode m = new MorseCode();
		m.encode("s E aa");
	}
}
