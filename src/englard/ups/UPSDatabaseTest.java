package englard.ups;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase upsd = new UPSDatabase();
		Location l = new Location(1L, 1L);
		Package p = new Package("one");
		HashSet<Package> set = new HashSet<Package>();
		set.add(p);
		upsd.addPackageToLocation(l, p);
		Assert.assertEquals(l, upsd.getLocation(p));
		Assert.assertEquals(set, upsd.getPackages(l));
	}

	@Test
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase upsd = new UPSDatabase();
		Location l = new Location(1L, 1L);
		Package p = new Package("one");
		HashSet<Package> set = new HashSet<Package>();
		set.add(p);
		upsd.addPackageToLocation(l, p);
		Location updated = new Location(2L, 2L);
		upsd.updatePackageLocation(p, updated);
		Assert.assertEquals(updated, upsd.getLocation(p));
		Assert.assertEquals(set, upsd.getPackages(updated));
		Assert.assertNotEquals(set, upsd.getPackages(l));
	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase upsd = new UPSDatabase();
		Location l = new Location(1L, 1L);
		Assert.assertEquals(new HashSet<Package>(), upsd.getPackages(l));
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase upsd = new UPSDatabase();
		Package p = new Package("one");
		Assert.assertNull(upsd.getLocation(p));
	}
}
