package entities;

public class Tenant {

	private String name;
	private String email;
	private int roomNumber;
	
	public Tenant(String name, String email, int roomNumber) {
		this.name = name;
		this.email = email;
		this.roomNumber = roomNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Tenant data: " + 
				"Room " + 
				roomNumber + 
				", " + 
				name + 
				", " + 
				email +
				".";				
	}	
	
	
}
