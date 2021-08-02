package com.grunseg.bitacora.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grunseg.bitacora.apirest.models.entity.Empresa;

public interface IEmpresaDao extends JpaRepository<Empresa, Long> {

}
