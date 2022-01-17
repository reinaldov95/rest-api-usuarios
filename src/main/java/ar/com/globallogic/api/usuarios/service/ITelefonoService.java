package ar.com.globallogic.api.usuarios.service;

import java.util.List;

import ar.com.globallogic.api.usuarios.entity.Telefono;
import ar.com.globallogic.api.usuarios.models.dto.TelefonoDTO;

public interface ITelefonoService {
	
	public List<Telefono> findAll();
	
	public TelefonoDTO save(Telefono telefono);

}
