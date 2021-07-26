package com.grunseg.bitacora.apirest.models.services;

import java.util.List;

import com.grunseg.bitacora.apirest.models.entity.AcompaniantesVisitante;
import com.grunseg.bitacora.apirest.models.entity.Bitacora;
import com.grunseg.bitacora.apirest.models.entity.Motivo;
import com.grunseg.bitacora.apirest.models.entity.Persona;
import com.grunseg.bitacora.apirest.models.entity.VehiculoVisitante;
import com.grunseg.bitacora.apirest.models.entity.Visitante;

public interface IBitacoraService {

	/* Bitacora */
	public List<Bitacora> findAllBitacoraOrdenada();

	public List<Bitacora> findAll();

	public Bitacora findById(Long id);

	public Bitacora save(Bitacora bitacora);

	public void delete(Long id);

	public List<Motivo> findAllMotivos();
	/* Bitacora */
	

	/* Visitantes */
	public List<Visitante> findAllVisitantes();

	public Visitante findVisitanteById(Long id);

	public Visitante saveVisitante(Visitante visitante);

	public void deleteVisitanteById(Long id);
	/* Visitantes */

	/* Vehiculos Visitantes */
	public List<VehiculoVisitante> findAllVehiculoVisitantes();

	public VehiculoVisitante findVehiculoVisitanteById(Long id);

	public VehiculoVisitante saveVehiculoVisitante(VehiculoVisitante vehiculoVisitante);

	public void deleteVehiculoVisitanteById(Long id);
	/* Vehiculos Visitantes */
	
	/*Acompaniantes*/
	public AcompaniantesVisitante saveAcompaniante(AcompaniantesVisitante acompaniante);
	/*Acompaniantes*/

	public List<Persona> findByCedulaPersona(String cedula);

	public List<Persona> findByLotePersona(String lote);

	public List<Visitante> findByCedulaVisitante(String cedula);

	public List<VehiculoVisitante> findByPlacaVehiculoVisitante(String placa);

}
