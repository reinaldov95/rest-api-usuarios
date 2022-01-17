package ar.com.globallogic.api.usuarios.exceptions;

public class EmailException extends Exception{
	
	public EmailException() {}
	
	public EmailException(String error) {
		super(error);
	}

}
