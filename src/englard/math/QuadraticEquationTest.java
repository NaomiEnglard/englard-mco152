package englard.math;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {
	@Test
	public void getPositiveX() throws InvalidInputException {
		QuadraticEquation q = new QuadraticEquation(1.0, -3.0, -4.0);
		Assert.assertEquals(4.0, q.getPositiveX(), 0.1);

	}

	@Test
	public void getNegativeX() throws InvalidInputException {
		QuadraticEquation q = new QuadraticEquation(1.0, -3.0, -4.0);
		Assert.assertEquals(-1.0, q.getNegativeX(), 0.1);
	}

	@Test
	public void testThrowsInvalidInputExceptionForA() {
		QuadraticEquation q;
		try {
			q = new QuadraticEquation(0, -3.0, -4.0);
			Assert.fail("quadratic may not have a 0 as A value");
		} catch (InvalidInputException e) {
			// expected
		}
	}

	@Test
	public void testThrowsInvalidInputExceptionForB() {
		QuadraticEquation q;
		try {
			q = new QuadraticEquation(1.0, 0, -4.0);
			Assert.fail("quadratic may not have a 0 as B value");
		} catch (InvalidInputException e) {
			// expected
		}
	}
}
