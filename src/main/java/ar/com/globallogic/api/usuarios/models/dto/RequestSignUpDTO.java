package ar.com.globallogic.api.usuarios.models.dto;

import java.util.List;

public class RequestSignUpDTO {
	
	private String name;
	private String email;
	private String password;
	
	private List<TelefonoDTO> phones;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TelefonoDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<TelefonoDTO> phones) {
		this.phones = phones;
	}	
	
	

}
