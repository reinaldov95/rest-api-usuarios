package ar.com.globallogic.api.usuarios.models.dto;

import java.util.List;

public class ErrorDTO {
	
	private List<ExceptionDTO> error;

	public List<ExceptionDTO> getError() {
		return error;
	}

	public void setError(List<ExceptionDTO> error) {
		this.error = error;
	}

	
	

}
