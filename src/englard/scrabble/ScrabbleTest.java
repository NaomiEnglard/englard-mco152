package englard.scrabble;

import java.io.FileNotFoundException;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ScrabbleTest {

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
