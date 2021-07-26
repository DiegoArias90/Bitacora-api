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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grunseg.bitacora.apirest.models.entity.VehiculoVisitante;
import com.grunseg.bitacora.apirest.models.services.IBitacoraService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class VehiculoVisitanteRestController {

	@Autowired
	private IBitacoraService bitacoraService;

	@GetMapping("/vehiculosVisitantes")
	public List<VehiculoVisitante> all() {
		return bitacoraService.findAllVehiculoVisitantes();
	}

	@GetMapping("/vehiculosVisitantes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		VehiculoVisitante vehiculo = null;
		Map<String, Object> resp = new HashMap<>();

		try {
			vehiculo = bitacoraService.findVehiculoVisitanteById(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al realizar la consulta con la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (vehiculo == null) {
			resp.put("msg",
					"El vehiculo del visitante con el id: ".concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<VehiculoVisitante>(vehiculo, HttpStatus.OK);
	}

	@PostMapping("/vehiculosVisitantes")
	public ResponseEntity<?> create(@Valid @RequestBody VehiculoVisitante vehiculoVisitante, BindingResult result) {
		VehiculoVisitante vehiculoNew = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			vehiculoNew = bitacoraService.saveVehiculoVisitante(vehiculoVisitante);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "El visitante ha sido creado con éxito!");
		response.put("vehiculo", vehiculoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/vehiculosVisitantes/filtrar-vehiculo-placa/{placa}")
	@ResponseStatus(HttpStatus.OK)
	public List<VehiculoVisitante> busquedaVehiculoVisitantePlaca(@PathVariable String placa) {
		return bitacoraService.findByPlacaVehiculoVisitante(placa);
	}

	/*
	 * @PostMapping("/buscar") public ResponseEntity<?>
	 * exemplo(@RequestParam("placa")String placa) { Object retorno =
	 * vehiculoVisitanteService.buscarPlaca(placa); return
	 * ResponseEntity.ok(retorno); }
	 */

}
