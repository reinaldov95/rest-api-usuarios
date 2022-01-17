package ar.com.globallogic.api.usuarios.service;

import ar.com.globallogic.api.usuarios.entity.Usuario;

public interface IJwtTokenService {
	
	String generateToken(Usuario user);

}
