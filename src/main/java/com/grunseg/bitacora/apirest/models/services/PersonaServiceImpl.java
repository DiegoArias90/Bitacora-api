package com.grunseg.bitacora.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grunseg.bitacora.apirest.models.dao.IEmpleadoDao;
import com.grunseg.bitacora.apirest.models.dao.IEventoDao;
import com.grunseg.bitacora.apirest.models.dao.IPersonaDao;
import com.grunseg.bitacora.apirest.models.dao.IVehiculoPersonaDao;
import com.grunseg.bitacora.apirest.models.entity.Empleado;
import com.grunseg.bitacora.apirest.models.entity.Evento;
import com.grunseg.bitacora.apirest.models.entity.Persona;
import com.grunseg.bitacora.apirest.models.entity.TipoEmpleo;
import com.grunseg.bitacora.apirest.models.entity.TipoEvento;
import com.grunseg.bitacora.apirest.models.entity.TipoPersona;
import com.grunseg.bitacora.apirest.models.entity.VehiculoPersona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;

	@Autowired
	private IVehiculoPersonaDao vehiculoPersonaDao;

	@Autowired
	private IEmpleadoDao empleadoDao;

	@Autowired
	private IEventoDao eventoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findById(Long id) {
		return personaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personaDao.save(persona);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		personaDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoPersona> findAllTiposPersonas() {
		return personaDao.findAllTiposPersonas();
	}

	@Override
	public List<Persona> findByCedulaPersona(String cedula) {
		return personaDao.findByCedulaPersona(cedula);
	}

	@Override
	public List<Persona> findByLotePersona(String lote) {
		return personaDao.findByLotePersona(lote);
	}

	@Override
	public List<Persona> findByEstadoPersonaA() {
		return personaDao.findByEstadoPersonaA();
	}

	@Override
	public List<Persona> findByEstadoPersonaD() {
		return personaDao.findByEstadoPersonaA();
	}

	@Override
	@Transactional(readOnly = true)
	public List<VehiculoPersona> findAllVehiculos() {
		return vehiculoPersonaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public VehiculoPersona findVehiculoPersonaById(Long id) {
		return vehiculoPersonaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public VehiculoPersona saveVehiculoPersona(VehiculoPersona vehiculoPersona) {
		return vehiculoPersonaDao.save(vehiculoPersona);
	}

	@Override
	@Transactional
	public void deleteVehiculoPersonaById(Long id) {
		vehiculoPersonaDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAllEmpleados() {
		return empleadoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findEmpleadoById(Long id) {
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empleado saveEmpleado(Empleado empleado) {
		return empleadoDao.save(empleado);
	}

	@Override
	@Transactional
	public void deleteEmpleadoById(Long id) {
		empleadoDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoEmpleo> findAllTiposEmpleos() {
		return empleadoDao.findAllTiposEmpleos();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Evento> findAllEventos() {
		return eventoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Evento findEventoById(Long id) {
		return eventoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Evento saveEvento(Evento evento) {
		return eventoDao.save(evento);
	}

	@Override
	@Transactional
	public void deleteEventoById(Long id) {
		eventoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoEvento> findAllTiposEventos() {
		return eventoDao.findAllTiposEventos();
	}

}
