package ar.com.globallogic.api.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.globallogic.api.usuarios.dao.TelefonoDao;
import ar.com.globallogic.api.usuarios.entity.Telefono;
import ar.com.globallogic.api.usuarios.models.dto.TelefonoDTO;
import ar.com.globallogic.api.usuarios.models.dto.UsuarioDTO;

@Service
public class TelefonoService implements ITelefonoService {
	
	@Autowired
	private TelefonoDao telefonoDao;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public List<Telefono> findAll() {
		return (List<Telefono>) telefonoDao.findAll();
	}

	@Override
	public TelefonoDTO save(Telefono telefono) {
		Telefono tel = new Telefono();
		
		tel = telefonoDao.save(telefono);
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		TelefonoDTO resp = mapper.convertValue(tel, TelefonoDTO.class);
		
		return resp;
	}

}
