package ar.com.globallogic.api.usuarios.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TelefonoDTO {

	private long number;
	private int citycode;
	private String contrycode;
	
	
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

	
	
}
