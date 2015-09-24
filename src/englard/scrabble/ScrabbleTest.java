package englard.scrabble;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class ScrabbleTest {

	@Test
	public void testContains() throws IOException {
		ScrabbleDictionary sD = new ScrabbleDictionary();
		Assert.assertTrue(sD.contains("pickle"));

	}

}
