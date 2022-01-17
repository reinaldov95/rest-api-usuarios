package ar.com.globallogic.api.usuarios.models.dto;

import java.sql.Timestamp;

public class ExceptionDTO {

	 private Timestamp timestamp;
	 private int codigo;
	 private String detail;
	 
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	 
	 
	
}
