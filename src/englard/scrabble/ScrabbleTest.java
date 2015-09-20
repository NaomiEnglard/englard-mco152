package englard.scrabble;

import java.io.FileNotFoundException;

import org.junit.Test;

import junit.framework.Assert;

public class ScrabbleTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testcontains() {
		try {
			ScrabbleDictionary sD = new ScrabbleDictionary();
			Assert.assertTrue(sD.contains("pickle"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
