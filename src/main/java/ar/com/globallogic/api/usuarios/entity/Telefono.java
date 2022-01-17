package ar.com.globallogic.api.usuarios.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefonos")
public class Telefono implements Serializable{

	private static final long serialVersionUID = 2592590129368087694L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private long number;
	private int citycode;
	private String contrycode;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}
	
	public void setNumber(long number) {
		this.number = number;
	}
	
	public int getCitycode() {
		return citycode;
	}
	
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	
	public String getContrycode() {
		return contrycode;
	}
	
	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	public String getUsuario_id() {
		return this.usuario.getId();
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
