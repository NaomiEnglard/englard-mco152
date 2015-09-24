package englard.math;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {
	@Test
	public void testSetAB() throws InvalidDataException {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setAB(2.2, 4.7);
		Assert.assertEquals(5.19, pT.getC(), .01);

	}

	@Test
	public void TestSetAC() throws InvalidDataException {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setAC(3.2, 7.3);
		Assert.assertEquals(6.56, pT.getB(), .01);

	}

	@Test
	public void TestSetBC() throws InvalidDataException {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setBC(5.0, 10.2);
		Assert.assertEquals(8.89, pT.getA(), .01);

	}
}
