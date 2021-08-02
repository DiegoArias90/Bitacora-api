package com.grunseg.bitacora.apirest.models.services;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.grunseg.bitacora.apirest.dto.AntecedentesInfoDTO;
import com.grunseg.bitacora.apirest.dto.VehiculoInfoDTO;
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

	@Autowired
	RestTemplate restTemplate;

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

	@SuppressWarnings("deprecation")
	@Override
	public VehiculoInfoDTO searchVehiculoByExternalService(String placa) {
		// String json =
		// "{\"codigoVehiculo\":927149,\"numeroPlaca\":\"PYH0156\",\"numeroCamvCpn\":\"E00007822\",\"colorVehiculo1\":\"BLANCO\",\"colorVehiculo2\":\"BLANCO\",\"cilindraje\":2700,\"nombreClase\":\"JEEP\",\"descripcionMarca\":\"HYUNDAI\",\"descripcionModelo\":\"SANTA
		// FE 4WD\",\"anioAuto\":2002,\"descripcionPais\":\"COREA DEL
		// SUR\",\"mensajeMotivoAuto\":\"Veh\u00edculo en estado bloqueado hasta la
		// regularizaci\u00f3n del registro de la transferencia de dominio, de
		// conformidad a lo informado por la Agencia Nacional de
		// Tr\u00e1nsito.\",\"aplicaCuota\":false,\"fechaUltimaMatricula\":\"2013-11-18\",\"fechaCaducidadMatricula\":\"2013-11-18\",\"fechaCompraRegistro\":\"2002-04-18\",\"fechaRevision\":\"2013-11-18\",\"descripcionCanton\":\"SANTO
		// DOMINGO\",\"descripcionServicio\":\"PARTICULAR\",\"ultimoAnioPagado\":2013,\"prohibidoEnajenar\":\"NO\",\"observacion\":null,\"estadoExoneracion\":\"NO\"}";
		// VehiculoInfoDTO convertedObject = new Gson().fromJson(json,
		// VehiculoInfoDTO.class);
		String url = "http://www.ecuadorlegalonline.com/modulo/sri/matriculacion/consultar-vehiculo.php";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		builder.queryParam("placa", placa);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity request = new HttpEntity(headers);
		ResponseEntity<String> response = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request,
				String.class, 1);
		if (response.getStatusCode() == HttpStatus.OK) {
			String json = response.getBody().toString();
			String json3 = StringEscapeUtils.unescapeJava(json);
			json3 = json3.substring(1, json3.length() - 1);
			VehiculoInfoDTO responseData = new Gson().fromJson(json3, VehiculoInfoDTO.class);
			return responseData;
		} else {
			return null;
		}
	}

	@Override
	public List<AntecedentesInfoDTO> searchAntecedentesByExternalService(String numeroIdentificacion,
			String tipoIdentificacion) {
		String url = "http://certificados.ministeriodegobierno.gob.ec/gestorcertificados/antecedentes/data.php";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("tipo", "getDataWs");
		map.add("ci", numeroIdentificacion);
		map.add("tp", tipoIdentificacion);
		map.add("ise", "SI");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = this.restTemplate.postForEntity(url, request, String.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			String json = response.getBody().toString();
			System.out.println(json);
			AntecedentesInfoDTO[] responseData = new Gson().fromJson(json, AntecedentesInfoDTO[].class);
			return Arrays.asList(responseData);
		} else {
			return null;
		}
	}

}
