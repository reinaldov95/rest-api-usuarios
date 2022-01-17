package ar.com.globallogic.api.usuarios.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.globallogic.api.usuarios.entity.Telefono;

public interface TelefonoDao extends CrudRepository<Telefono, Long> {

}
