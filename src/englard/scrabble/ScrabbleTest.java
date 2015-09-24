package englard.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleTest {

	@Test
	public void testContains() throws IOException {
		ScrabbleDictionary sD = new ScrabbleDictionary();
		Assert.assertTrue(sD.contains("pickle"));

	}

}
