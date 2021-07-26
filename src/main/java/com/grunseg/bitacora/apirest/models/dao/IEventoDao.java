package com.grunseg.bitacora.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grunseg.bitacora.apirest.models.entity.Evento;

import com.grunseg.bitacora.apirest.models.entity.TipoEvento;

public interface IEventoDao extends JpaRepository<Evento, Long> {

	@Query("from TipoEvento")
	public List<TipoEvento> findAllTiposEventos();

}
