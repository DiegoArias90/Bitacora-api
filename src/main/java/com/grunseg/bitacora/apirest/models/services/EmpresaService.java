package com.grunseg.bitacora.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.grunseg.bitacora.apirest.models.dao.IEmpresaDao;
import com.grunseg.bitacora.apirest.models.entity.Empresa;

public class EmpresaService implements IEmpresaService {

	@Autowired
	private IEmpresaDao empresaDao;

	@Override
	public List<Empresa> findAll() {
		return empresaDao.findAll();
	}

	@Override
	public Empresa findById(Long id) {
		return empresaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empresa save(Empresa empresa) {
		return empresaDao.save(empresa);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		empresaDao.deleteById(id);

	}

}
