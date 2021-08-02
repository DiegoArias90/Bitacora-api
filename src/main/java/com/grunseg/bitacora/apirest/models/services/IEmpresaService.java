package com.grunseg.bitacora.apirest.models.services;

import java.util.List;

import com.grunseg.bitacora.apirest.models.entity.Empresa;

public interface IEmpresaService {

	public List<Empresa> findAll();

	public Empresa findById(Long id);

	public Empresa save(Empresa empresa);

	public void delete(Long id);

}
