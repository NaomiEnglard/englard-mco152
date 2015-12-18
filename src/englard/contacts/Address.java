package englard.contacts;

public class Address {

	private String street;
	private String suite;
	private String Apt;
	private String city;
	private String zipCode;

	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append(street);
		build.append(" suite ");
		build.append(suite);
		build.append(" Apt ");
		build.append(Apt);
		build.append("City ");
		build.append(city);
		if (zipCode != null) {
			build.append("Zip " + zipCode);
		}
		return build.toString();
	}

	public String getStreet() {
		return street;
	}

	public String getSuite() {
		return suite;
	}

	public String getApt() {
		return Apt;
	}

	public String getCity() {
		return city;
	}
}
