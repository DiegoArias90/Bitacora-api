package com.grunseg.bitacora.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grunseg.bitacora.apirest.models.entity.VehiculoVisitante;

public interface IVehiculoVisitanteDao extends JpaRepository<VehiculoVisitante, Long> {

	@Query("select p from VehiculoVisitante p where p.placa like %?1%")
	public List<VehiculoVisitante> findByPlacaVehiculoVisitante(String placa);

}
