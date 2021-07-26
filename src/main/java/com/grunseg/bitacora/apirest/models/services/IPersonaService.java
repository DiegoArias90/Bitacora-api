package com.grunseg.bitacora.apirest.models.services;

import java.util.List;

import com.grunseg.bitacora.apirest.models.entity.Empleado;
import com.grunseg.bitacora.apirest.models.entity.Evento;
import com.grunseg.bitacora.apirest.models.entity.Persona;
import com.grunseg.bitacora.apirest.models.entity.TipoEmpleo;
import com.grunseg.bitacora.apirest.models.entity.TipoEvento;
import com.grunseg.bitacora.apirest.models.entity.TipoPersona;
import com.grunseg.bitacora.apirest.models.entity.VehiculoPersona;

public interface IPersonaService {

	/* Personas */
	public List<TipoPersona> findAllTiposPersonas();
	
	public List<Persona> findAll();

	public Persona findById(Long id);

	public Persona save(Persona persona);

	public void delete(Long id);

	public List<Persona> findByCedulaPersona(String cedula);
	
	public List<Persona> findByLotePersona(String lote);
	
	public List<Persona> findByEstadoPersonaA();
	
	public List<Persona> findByEstadoPersonaD();
	
	/* Personas */

	/* Vehiculos Propietarios */
	public List<VehiculoPersona> findAllVehiculos();

	public VehiculoPersona findVehiculoPersonaById(Long id);

	public VehiculoPersona saveVehiculoPersona(VehiculoPersona vehiculoPersona);

	public void deleteVehiculoPersonaById(Long id);
	/* Vehiculos Propietarios */

	/* Empleados */
	public List<Empleado> findAllEmpleados();

	public Empleado findEmpleadoById(Long id);

	public Empleado saveEmpleado(Empleado empleado);

	public void deleteEmpleadoById(Long id);

	public List<TipoEmpleo> findAllTiposEmpleos();
	/* Empleados */

	/* Eventos */
	public List<Evento> findAllEventos();

	public Evento findEventoById(Long id);

	public Evento saveEvento(Evento evento);

	public void deleteEventoById(Long id);

	public List<TipoEvento> findAllTiposEventos();
	/* Eventos */

}
