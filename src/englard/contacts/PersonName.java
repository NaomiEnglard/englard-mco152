package englard.contacts;

public class PersonName {

	private String firstName;
	private String lastName;

	public PersonName(String fullName) {
		String[] tokens = fullName.split(" ");
		firstName = tokens[0];
		lastName = tokens[1];

	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append(lastName);
		build.append(" ");
		build.append(" ");
		build.append(firstName);
		return build.toString();
	}

}
