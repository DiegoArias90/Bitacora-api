package com.grunseg.bitacora.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grunseg.bitacora.apirest.models.entity.EmpresaUsuario;

public interface IEmpresaUsuarioDao extends JpaRepository<EmpresaUsuario, Long> {

}
