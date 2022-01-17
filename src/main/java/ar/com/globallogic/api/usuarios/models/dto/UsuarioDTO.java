package ar.com.globallogic.api.usuarios.models.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {

	private String id;
	private String created;
	private boolean isActive;
	private String name;
	private String email;
	private String password;
	private String token;
	private String lastLogin;
	
	private List<TelefonoDTO> phones;	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCreated() {
		return created;
	}
	
	public void setCreated(String created) {
		this.created =  created;
	}
	
	public boolean isIsActive() {
		return isActive;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TelefonoDTO> getPhones() {
		return this.phones;
	}

	public void setPhones(List<TelefonoDTO> phones) {
		this.phones = phones;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}


}
