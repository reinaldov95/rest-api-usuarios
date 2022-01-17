package ar.com.globallogic.api.usuarios.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.com.globallogic.api.usuarios.entity.Usuario;
import ar.com.globallogic.api.usuarios.models.dto.UsuarioDTO;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
	
	public Usuario findByEmail(String email);
	
	public Usuario findByEmailAndPassword(String email, String password);
}
