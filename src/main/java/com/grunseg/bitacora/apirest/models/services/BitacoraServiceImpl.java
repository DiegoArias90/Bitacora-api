package com.grunseg.bitacora.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grunseg.bitacora.apirest.models.dao.IAcompaniateDao;
import com.grunseg.bitacora.apirest.models.dao.IBitacoraDao;
import com.grunseg.bitacora.apirest.models.dao.IPersonaDao;
import com.grunseg.bitacora.apirest.models.dao.IVehiculoVisitanteDao;
import com.grunseg.bitacora.apirest.models.dao.IVisitanteDao;
import com.grunseg.bitacora.apirest.models.entity.AcompaniantesVisitante;
import com.grunseg.bitacora.apirest.models.entity.Bitacora;
import com.grunseg.bitacora.apirest.models.entity.Motivo;
import com.grunseg.bitacora.apirest.models.entity.Persona;
import com.grunseg.bitacora.apirest.models.entity.VehiculoVisitante;
import com.grunseg.bitacora.apirest.models.entity.Visitante;

@Service
public class BitacoraServiceImpl implements IBitacoraService {

	@Autowired
	private IBitacoraDao bitacoraDao;

	@Autowired
	private IPersonaDao personaDao;

	@Autowired
	private IVisitanteDao visitanteDao;
	
	@Autowired
	private IAcompaniateDao acompaniateDao;

	@Autowired
	private IVehiculoVisitanteDao vehiculoVisitanteDao;

	@Override
	public List<Bitacora> findAllBitacoraOrdenada() {
		return bitacoraDao.findAllBitacoraOrdenada();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bitacora> findAll() {
		return bitacoraDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Bitacora findById(Long id) {
		return bitacoraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Bitacora save(Bitacora bitacora) {
		return bitacoraDao.save(bitacora);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		bitacoraDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Motivo> findAllMotivos() {
		return bitacoraDao.findAllMotivos();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Visitante> findAllVisitantes() {
		return visitanteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Visitante findVisitanteById(Long id) {
		return visitanteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Visitante saveVisitante(Visitante visitante) {
		return visitanteDao.save(visitante);
	}

	@Override
	@Transactional
	public void deleteVisitanteById(Long id) {
		visitanteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public VehiculoVisitante findVehiculoVisitanteById(Long id) {
		return vehiculoVisitanteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public VehiculoVisitante saveVehiculoVisitante(VehiculoVisitante vehiculoVisitante) {
		return vehiculoVisitanteDao.save(vehiculoVisitante);
	}

	@Override
	@Transactional
	public void deleteVehiculoVisitanteById(Long id) {
		vehiculoVisitanteDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findByCedulaPersona(String cedula) {
		return personaDao.findByCedulaPersona(cedula);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findByLotePersona(String lote) {
		return personaDao.findByLotePersona(lote);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Visitante> findByCedulaVisitante(String cedula) {
		return visitanteDao.findByCedulaVisitante(cedula);
	}

	@Override
	@Transactional(readOnly = true)
	public List<VehiculoVisitante> findByPlacaVehiculoVisitante(String placa) {
		return vehiculoVisitanteDao.findByPlacaVehiculoVisitante(placa);
	}

	@Override
	public List<VehiculoVisitante> findAllVehiculoVisitantes() {
		return vehiculoVisitanteDao.findAll();
	}

	@Override
	public AcompaniantesVisitante saveAcompaniante(AcompaniantesVisitante acompaniante) {
		return acompaniateDao.save(acompaniante);
	}

}
