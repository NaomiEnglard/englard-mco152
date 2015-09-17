package englard.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {
	@Test
	public void testEncode() {
		MorseCode mC = new MorseCode();
		Assert.assertEquals("... .... -- ..- . .-..   .", mC.encode("Shmuel E"));
	}

	@Test
	public void testDecode() {
		MorseCode mC = new MorseCode();
		String x = "Shmuel E";
		Assert.assertEquals(x.toUpperCase(),
				mC.decode("... .... -- ..- . .-..   ."));
	}
}
