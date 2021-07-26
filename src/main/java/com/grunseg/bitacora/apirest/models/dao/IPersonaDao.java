package com.grunseg.bitacora.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.grunseg.bitacora.apirest.models.entity.Persona;
import com.grunseg.bitacora.apirest.models.entity.TipoPersona;

public interface IPersonaDao extends JpaRepository<Persona, Long> {

	@Query("from TipoPersona")
	public List<TipoPersona> findAllTiposPersonas();
	
	@Query("select p from Persona p where p.cedula like %?1%")
	public List<Persona> findByCedulaPersona(String cedula);
	
	@Query("select p from Persona p where p.lote like %?1%")
	public List<Persona> findByLotePersona(String lote);
	
	@Query("from Persona where estado is true ORDER BY fecha_actualizacion DESC")
	public List<Persona> findByEstadoPersonaA();
	
	@Query("from Persona where estado is false ORDER BY fecha_actualizacion DESC")
	public List<Persona> findByEstadoPersonaD();

}
