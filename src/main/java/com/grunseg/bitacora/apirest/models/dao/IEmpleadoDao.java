package com.grunseg.bitacora.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grunseg.bitacora.apirest.models.entity.Empleado;
import com.grunseg.bitacora.apirest.models.entity.TipoEmpleo;


public interface IEmpleadoDao extends JpaRepository<Empleado, Long> {
	
	@Query("from TipoEmpleo")
	public List<TipoEmpleo> findAllTiposEmpleos();

}
