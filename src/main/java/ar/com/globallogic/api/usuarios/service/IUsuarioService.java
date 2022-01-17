package ar.com.globallogic.api.usuarios.service;

import java.util.List;

import ar.com.globallogic.api.usuarios.entity.Usuario;
import ar.com.globallogic.api.usuarios.models.dto.RequestSignUpDTO;
import ar.com.globallogic.api.usuarios.models.dto.UsuarioDTO;

public interface IUsuarioService {

	public UsuarioDTO crearUsuario(Usuario usuario);
	
	public List<UsuarioDTO> findAll();
	
	public UsuarioDTO findByEmail(String email);
	
	public UsuarioDTO findByEmailAndPassword(String email, String password);
}
