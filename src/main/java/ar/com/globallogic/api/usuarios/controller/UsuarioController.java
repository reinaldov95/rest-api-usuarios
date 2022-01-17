package ar.com.globallogic.api.usuarios.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ar.com.globallogic.api.usuarios.entity.Telefono;
import ar.com.globallogic.api.usuarios.entity.Usuario;
import ar.com.globallogic.api.usuarios.models.dto.ErrorDTO;
import ar.com.globallogic.api.usuarios.models.dto.ExceptionDTO;
import ar.com.globallogic.api.usuarios.models.dto.RequestLoginDto;
import ar.com.globallogic.api.usuarios.models.dto.RequestSignUpDTO;
import ar.com.globallogic.api.usuarios.models.dto.TelefonoDTO;
import ar.com.globallogic.api.usuarios.models.dto.UsuarioDTO;
import ar.com.globallogic.api.usuarios.service.ITelefonoService;
import ar.com.globallogic.api.usuarios.service.IUsuarioService;
import ar.com.globallogic.api.usuarios.util.Commons;
import ar.com.globallogic.api.usuarios.util.Validation;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private ITelefonoService telefonoService;
	
	ErrorDTO error = new ErrorDTO();
	ExceptionDTO exception = new ExceptionDTO();
	List<ExceptionDTO> exceptionList = new ArrayList<ExceptionDTO>();
	
	@PostMapping("/sign-up")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> crearUsuario(@RequestBody RequestSignUpDTO user) {

		UsuarioDTO usuarioDto = new UsuarioDTO(); 
		Usuario usuarioNuevo = new Usuario();
		List<Telefono> telefonos = new ArrayList<>();

			if(!Validation.validarEmail(user.getEmail())) {
				exceptionList.clear();
				exception.setTimestamp(new Timestamp(new Date().getTime()));
				exception.setCodigo(HttpStatus.BAD_REQUEST.value());
				exception.setDetail("El Email ingresado no es valido");
				
				exceptionList.add(exception);
				error.setError(exceptionList);
				 
				return ResponseEntity.status(exception.getCodigo()).body(error);
			}
			
			if(buscarEmail(user.getEmail()) != null) {
				exceptionList.clear();
				exception.setTimestamp(new Timestamp(new Date().getTime()));
				exception.setCodigo(HttpStatus.BAD_REQUEST.value());
				exception.setDetail("El usuario ya se encientra registrado");
				
				exceptionList.add(exception);
				error.setError(exceptionList);
				 
				return ResponseEntity.status(exception.getCodigo()).body(error);
			}
				
				usuarioNuevo.setName(user.getName());
				usuarioNuevo.setEmail(user.getEmail());
				usuarioNuevo.setPassword(user.getPassword());
				//usuarioNuevo.setPhones(user.getPhones());
			
				user.setPassword(Commons.encodePassword(user.getPassword()));

				for(int i = 0; i < user.getPhones().size(); i++) {
					Telefono telefono = new Telefono();
					telefono.setCitycode(user.getPhones().get(i).getCitycode());
					telefono.setContrycode(user.getPhones().get(i).getContrycode());
					telefono.setNumber(user.getPhones().get(i).getNumber());
					telefonos.add(telefono);
				}
				
				usuarioNuevo.setPhones(telefonos);
				
				usuarioDto = usuarioService.crearUsuario(usuarioNuevo);

				for(Telefono tel: usuarioNuevo.getPhones()) {
					saveTelefono(tel);
				}
			 
		UsuarioDTO userFormat = new UsuarioDTO();
		userFormat.setId(usuarioDto.getId());
		userFormat.setCreated(usuarioDto.getCreated());
		userFormat.setIsActive(usuarioDto.isIsActive());
		userFormat.setToken(usuarioDto.getToken());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userFormat);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody RequestLoginDto login) {
		UsuarioDTO usuario = usuarioService.findByEmailAndPassword(login.getEmail(), login.getPassword());
		
		if(null == usuario) {
			exceptionList.clear();
			exception.setTimestamp(new Timestamp(new Date().getTime()));
			exception.setCodigo(HttpStatus.BAD_REQUEST.value());
			exception.setDetail("Email o Password Inocorrectos");
			
			exceptionList.add(exception);
			error.setError(exceptionList);
			 
			return ResponseEntity.status(exception.getCodigo()).body(error);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	
	public TelefonoDTO saveTelefono(@RequestBody Telefono telefono) {
		return telefonoService.save(telefono);
	}
	
	public UsuarioDTO buscarEmail(String email) {
		return usuarioService.findByEmail(email);
	}

}
