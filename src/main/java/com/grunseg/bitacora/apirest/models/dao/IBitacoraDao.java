package com.grunseg.bitacora.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.grunseg.bitacora.apirest.models.entity.Bitacora;
import com.grunseg.bitacora.apirest.models.entity.Motivo;

public interface IBitacoraDao extends JpaRepository<Bitacora, Long> {

	@Query("from Bitacora where hora_salida is null ORDER BY hora_ingreso DESC")
	public List<Bitacora> findAllBitacoraOrdenada();

	@Query("from Motivo")
	public List<Motivo> findAllMotivos();

}
