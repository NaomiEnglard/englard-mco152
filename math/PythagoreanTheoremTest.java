package englard.math;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {
	@Test
	public void setAB() {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setAB(2.2, 4.7);
		Assert.assertEquals(pT.getC(), 5.19, .01);
	}

	@Test
	public void setAC() {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setAC(3.2, 7.3);
		Assert.assertEquals(pT.getB(), 6.56, .01);
	}

	@Test
	public void setBC() {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setBC(5.0, 10.2);
		Assert.assertEquals(pT.getA(), 8.89, .01);
	}

}
