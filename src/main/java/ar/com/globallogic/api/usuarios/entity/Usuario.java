package ar.com.globallogic.api.usuarios.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 7244843279178582477L;
	
	@Id
	private String id;
	
	private String name;
	private String email;
	
	private String password;
	
	private String created;
	private boolean isActive;
	
	private String lastLogin;
	
	@Lob
	private String token;
	
	
	@OneToMany(mappedBy = "usuario")
	private List<Telefono> phones;	

	public Usuario() {
		UUID uuid = UUID.randomUUID();
		this.id = uuid.toString();
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public boolean isIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public List<Telefono> getPhones() {
		return phones;
	}

	public void setPhones(List<Telefono> phones) {
		this.phones = phones;
	}


	public String getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

}
