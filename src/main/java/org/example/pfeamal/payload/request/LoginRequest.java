package org.example.pfeamal.payload.request;



import javax.validation.constraints.NotBlank;


public class LoginRequest {
	@NotBlank
	private String username;

	@NotBlank
	private String password;
	/*private String address;
	//private String city;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}*/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
