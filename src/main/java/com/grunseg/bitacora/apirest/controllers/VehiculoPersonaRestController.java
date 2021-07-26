package com.grunseg.bitacora.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grunseg.bitacora.apirest.models.entity.VehiculoPersona;
import com.grunseg.bitacora.apirest.models.services.IPersonaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class VehiculoPersonaRestController {
	
	@Autowired
	private IPersonaService personaService;

	@GetMapping("/vehiculosPersonas")
	public List<VehiculoPersona> all() {
		return personaService.findAllVehiculos();
	}

	@GetMapping("/vehiculosPersonas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		VehiculoPersona vehiculoPersona = null;
		Map<String, Object> resp = new HashMap<>();

		try {
			vehiculoPersona = personaService.findVehiculoPersonaById(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al realizar la consulta con la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (vehiculoPersona == null) {
			resp.put("msg", "El vehículo con el id: ".concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<VehiculoPersona>(vehiculoPersona, HttpStatus.OK);
	}

	@PostMapping("/vehiculosPersonas")
	public ResponseEntity<?> create(@Valid @RequestBody VehiculoPersona vehiculoPersona, BindingResult result) {
		VehiculoPersona vehiculoNew = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			vehiculoNew = personaService.saveVehiculoPersona(vehiculoPersona);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "El vehículo ha sido creado con éxito!");
		response.put("vehículo", vehiculoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/vehiculosPersonas/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody VehiculoPersona vehiculoPersona, BindingResult result,
			@PathVariable Long id) {
		VehiculoPersona vehiculoActual = personaService.findVehiculoPersonaById(id);
		VehiculoPersona vehiculoUpdated = null;
		Map<String, Object> resp = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			resp.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
		}

		if (vehiculoActual == null) {
			resp.put("msg", "Error: No se puede editar el empleado con el id: "
					.concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}

		try {
			vehiculoActual.setPlaca(vehiculoPersona.getPlaca());
			vehiculoActual.setModelo(vehiculoPersona.getModelo());
			vehiculoActual.setMarca(vehiculoPersona.getMarca());
			vehiculoActual.setColor(vehiculoPersona.getColor());
			vehiculoActual.setTipoVehiculo(vehiculoPersona.getTipoVehiculo());
			vehiculoActual.setDetalle(vehiculoPersona.getDetalle());
			vehiculoUpdated = personaService.saveVehiculoPersona(vehiculoActual);

		} catch (DataAccessException e) {
			resp.put("msg", "Error al actualizar el vehículo en la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "El vehículo a sido actualizado con exito");
		resp.put("vehículo", vehiculoUpdated);

		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.CREATED);
	}

	@DeleteMapping("/vehiculosPersonas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> resp = new HashMap<>();
		try {
			personaService.deleteVehiculoPersonaById(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al eliminar el vehículo de la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "El vehículo a sido eliminado con exito!");
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);

	}

}
