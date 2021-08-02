package com.grunseg.bitacora.apirest.models.services;

import java.util.List;

import com.grunseg.bitacora.apirest.models.entity.EmpresaUsuario;

public interface IEmpresaUsuario {

	public List<EmpresaUsuario> findAll();

	public EmpresaUsuario findById(Long id);

	public EmpresaUsuario save(EmpresaUsuario empresaUsuario);

	public void delete(Long id);
}
