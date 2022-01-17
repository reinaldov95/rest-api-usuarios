package ar.com.globallogic.api.usuarios.service;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.globallogic.api.usuarios.dao.UsuarioDao;
import ar.com.globallogic.api.usuarios.entity.Telefono;
import ar.com.globallogic.api.usuarios.entity.Usuario;
import ar.com.globallogic.api.usuarios.models.dto.TelefonoDTO;
import ar.com.globallogic.api.usuarios.models.dto.UsuarioDTO;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private UsuarioDao userDao;
	
	@Autowired
	private IJwtTokenService jwtToken;
	
	
	private ObjectMapper mapper = new ObjectMapper();
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		
	
	@Override
	public UsuarioDTO crearUsuario(Usuario usuario) {
		final String token = jwtToken.generateToken(usuario);

		usuario.setCreated(simpleDateFormat.format(new Date()));
		usuario.setToken(token);
		usuario.setLastLogin(dtf.format(LocalDateTime.now()));
		
		Usuario user = userDao.save(usuario);
		
		user.setPhones(usuario.getPhones());
		for(Telefono tel: user.getPhones()) {
			tel.setUsuario(user);
		}
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		UsuarioDTO resp = mapper.convertValue(user, UsuarioDTO.class);

		return resp;
	}

	@Override
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = (List<Usuario>) userDao.findAll();
		
		List<UsuarioDTO> result = mapper.convertValue(usuarios , new TypeReference<List<UsuarioDTO>>() { });
		
		return result;
	}

	@Override
	public UsuarioDTO findByEmail(String email) {
		Optional<Usuario> usuario = null;
		
		usuario = Optional.ofNullable(userDao.findByEmail(email));
		
		if(usuario.isPresent()) {
			UsuarioDTO rspt = mapper.convertValue(usuario.get(), UsuarioDTO.class);
	        return rspt;
		}
		return null;
	}

	@Override
	public UsuarioDTO findByEmailAndPassword(String email, String password) {
		Optional<Usuario> usuario = null;
		
		usuario = Optional.ofNullable(userDao.findByEmailAndPassword(email, password));
		
		if(usuario.isPresent()) {
			UsuarioDTO rspt = mapper.convertValue(usuario.get(), UsuarioDTO.class);
	        return rspt;
		}
		return null;
	}

	
}
