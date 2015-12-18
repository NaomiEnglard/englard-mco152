package englard.contacts;

public class ContactInfo {
	
	private int id;
	private String name;
	private String userName;
	private String email;
	private Address address;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address.toString();
	}
	

}
