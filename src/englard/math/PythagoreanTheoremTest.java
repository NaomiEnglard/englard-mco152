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
	public void testSetAC() throws InvalidDataException {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setAC(3.2, 7.3);
		Assert.assertEquals(6.56, pT.getB(), .01);

	}

	@Test
	public void testSetBC() throws InvalidDataException {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setBC(5.0, 10.2);
		Assert.assertEquals(8.89, pT.getA(), .01);

	}

	@Test
	public void testGetA() {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		try {
			pT.getA();
			Assert.fail("no getters before setters");
		} catch (InvalidDataException e) {
			// expected
		}
	}

	@Test
	public void testGetB() {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		try {
			pT.getB();
			Assert.fail("no getters before setters");
		} catch (InvalidDataException e) {
			// expected
		}
	}

	@Test
	public void testGetC() {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		try {
			pT.getA();
			Assert.fail("no getters before setters");
		} catch (InvalidDataException e) {
			// expected
		}
	}

}
