package englard.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {

	private HashMap<Location, HashSet<Package>> upsLP;
	private HashMap<Package, Location> upsPL;

	public UPSDatabase() {

		upsLP = new HashMap<Location, HashSet<Package>>();
		upsPL = new HashMap<Package, Location>();
	}

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		if (upsLP.containsKey(location)) {
			HashSet<Package> packages = upsLP.get(location);
			packages.add(pkg);
			upsLP.put(location, packages);
		} else {
			HashSet<Package> firstPackage = new HashSet<Package>();
			firstPackage.add(pkg);
			upsLP.put(location, firstPackage);
		}
		upsPL.put(pkg, location);
	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {
		// find where the package was and remove it
		Location prevLocation = getLocation(pkg);
		HashSet<Package> packages = upsLP.get(prevLocation);
		packages.remove(pkg);
		upsLP.put(prevLocation, packages);
		// add package to new location
		addPackageToLocation(location, pkg);
		upsPL.put(pkg, location);

	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.
	 */
	public Set<Package> getPackages(Location location) {
		if (upsLP.get(location) == null) {
			return new HashSet<Package>();
		}
		return upsLP.get(location);
	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		return upsPL.get(pkg);
	}

}
