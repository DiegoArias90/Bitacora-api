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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grunseg.bitacora.apirest.models.entity.AcompaniantesVisitante;
import com.grunseg.bitacora.apirest.models.entity.Bitacora;
import com.grunseg.bitacora.apirest.models.entity.Motivo;
import com.grunseg.bitacora.apirest.models.services.IBitacoraService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class BitacoraRestController {
	
	@Autowired
	private IBitacoraService bitacoraService;
	
	@GetMapping("/bitacora")
	public List<Bitacora> all(){
		return bitacoraService.findAll();
	}
	
	@GetMapping("/bitacoraOrdenada")
	public List<Bitacora> allOrdenada(){
		return bitacoraService.findAllBitacoraOrdenada();
	}
	
	@GetMapping("/bitacora/{id}")
	public ResponseEntity<?> show( @PathVariable Long id ) {
		Bitacora bitacora = null;
		Map<String, Object> resp = new HashMap<>();
		
		try {
			bitacora = bitacoraService.findById(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al realizar la consulta con la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (bitacora == null) {
			resp.put("msg", "La bitacora con el id: ".concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Bitacora>(bitacora, HttpStatus.OK);
	}
	
	@PostMapping("/bitacora")
	public ResponseEntity<?> create( @Valid @RequestBody Bitacora bitacora, AcompaniantesVisitante acompaniates, BindingResult result ) {
		Bitacora bitacoraNew = null;
		AcompaniantesVisitante acompaniatesNew = null;
		
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			
			if (acompaniates != null) {
				acompaniatesNew = bitacoraService.saveAcompaniante(acompaniates);
			}
			
			bitacoraNew = bitacoraService.save(bitacora);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "La bitacora ha sido creada con éxito!");
		response.put("bitacora", bitacoraNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/bitacora/acompaniates")
	public ResponseEntity<?> create( @RequestBody AcompaniantesVisitante acompaniates ) {
		
		AcompaniantesVisitante acompaniatesNew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			acompaniatesNew = bitacoraService.saveAcompaniante(acompaniates);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "Se ha agregado correctamente los acompañanates a la bitacora creada!");
		response.put("bitacora", acompaniatesNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/bitacora/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Bitacora bitacora, BindingResult result, @PathVariable Long id) {
		Bitacora bitacoraActual = bitacoraService.findById(id);
		Bitacora bitacoraUpdated = null;
		Map<String, Object> resp = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			resp.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
		}

		if (bitacoraActual == null) {
			resp.put("msg", "Error: No se puede editar la persona con el id: "
					.concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}
		
		try {
		bitacoraActual.setHoraSalida(bitacora.getHoraSalida());	
		bitacoraUpdated = bitacoraService.save(bitacoraActual);
		
		} catch (DataAccessException e) {
			resp.put("msg", "Error al actualizar la persona en la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "La bitacora a sido actualizado con exito");
		resp.put("bitacora", bitacoraUpdated);

		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/bitacora/motivos")
	public List<Motivo> listarTiposPersonas(){
		return bitacoraService.findAllMotivos();
	}

}
