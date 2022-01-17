package ar.com.globallogic.api.usuarios.util;

import java.util.Base64;

public class Commons {
	
	public static String encodePassword(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
	
	public static String decodePassword(String password) {
		byte[] passbyte = Base64.getDecoder().decode(password);
		 String decodedPass = new String(passbyte);
		 return decodedPass;
	}

}
