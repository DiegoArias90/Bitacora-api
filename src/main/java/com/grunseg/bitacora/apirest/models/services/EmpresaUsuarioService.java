package com.grunseg.bitacora.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.grunseg.bitacora.apirest.models.dao.IEmpresaUsuarioDao;
import com.grunseg.bitacora.apirest.models.entity.EmpresaUsuario;

public class EmpresaUsuarioService implements IEmpresaUsuario {

	@Autowired
	private IEmpresaUsuarioDao empresaUsuarioDao;

	@Override
	public List<EmpresaUsuario> findAll() {
		return empresaUsuarioDao.findAll();
	}

	@Override
	public EmpresaUsuario findById(Long id) {
		return empresaUsuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public EmpresaUsuario save(EmpresaUsuario empresaUsuario) {
		return empresaUsuarioDao.save(empresaUsuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		empresaUsuarioDao.deleteById(id);

	}

}
