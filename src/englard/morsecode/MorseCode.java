package englard.morsecode;

import java.util.ArrayList;

import org.junit.Test;

public class MorseCode {
	private String codedMessage;
	private String decodedMessage;

	public MorseCode() {

	}

	@Test
	public String encode(String message) {
		message = message.toUpperCase(); // convert message to upercase since
											// the mosrse code enum values are
											// upercase
		StringBuffer buffer = new StringBuffer();
		// create an array to hold each letter of the message
		char[] messageList = message.toCharArray();
		// loop through each letter
		for (int i = 0; i < messageList.length; i++) {
			for (MorseCodeEnum mCE : MorseCodeEnum.values())
				// find the letter as a enum
				if (messageList[i] == (mCE.toString().charAt(0))) {
					// append the code version to string that will be returned
					buffer.append(mCE.getCode());
					// between each letter should be a space
					if (i != (messageList.length - 1)) { // if its not the last
															// letter put a
															// space
						buffer.append(" ");
					}
					break;
				} else if (messageList[i] == ' ') {
					// the space between words gets converted into three spaces
					// in the morseCoe message
					buffer.append("  "); // only two spaces since the third will
											// be put after the previous letter
					break;
				}
		}
		return buffer.toString();
	}
	@Test
	public String decode(String code) {
		StringBuffer buffer = new StringBuffer();
		// create a string array to hold each "letter" of the code
		String[] messageList = code.split(" ");
		for (int i = 0; i < messageList.length; i++) { // translate each letter
			// find which letter should be used instead of a morse code string
			for (MorseCodeEnum mCE : MorseCodeEnum.values()) {
				// if the morse code string is the letter add the letter to
				// string buffer
				if (mCE.getCode().equals(messageList[i])) {
					buffer.append(mCE);
					break;
				} else if (messageList[i].equals("")) { // two spaces since
															// splitter used one
															// as a deliminator
					buffer.append(" ");
					i++; //skip the next space since three spaces come together
					break;
				}
			}
		}
		return buffer.toString();

	}

}
