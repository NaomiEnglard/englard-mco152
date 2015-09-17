package englard.scrabble;

import java.io.FileNotFoundException;

import org.junit.Test;

import junit.framework.Assert;

public class ScrabbleTest {

	@Test
	public void testcontains() {
		try {
			ScrabbleDictionary sD = new ScrabbleDictionary();
			boolean found = sD.contains("pickle");
			Assert.assertEquals(true, found);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
