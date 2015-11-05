package englard.prodjectile;

import org.junit.Assert;
import org.junit.Test;

public class ProdjectileTest {

	@Test
	public void testGetX() {
		Prodjectile p = new Prodjectile(31.0, 20.0, 2.7);
		Assert.assertEquals(27.81, p.getX(), .01);

	}
	@Test
	public void testGetY() {
		Prodjectile p = new Prodjectile(31.0, 20.0, 2.7);
		Assert.assertEquals(10.56, p.getY(), .01);
	}
	

}
