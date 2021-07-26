package com.grunseg.bitacora.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grunseg.bitacora.apirest.models.entity.Visitante;

public interface IVisitanteDao extends JpaRepository<Visitante, Long> {

	@Query("select p from Visitante p where p.cedula like %?1%")
	public List<Visitante> findByCedulaVisitante(String cedula);

}
