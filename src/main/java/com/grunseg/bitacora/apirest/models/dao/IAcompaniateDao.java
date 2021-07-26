package com.grunseg.bitacora.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grunseg.bitacora.apirest.models.entity.AcompaniantesVisitante;

public interface IAcompaniateDao extends JpaRepository<AcompaniantesVisitante, Long>{

}
