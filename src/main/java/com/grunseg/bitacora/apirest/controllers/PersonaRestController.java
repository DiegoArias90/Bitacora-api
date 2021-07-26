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
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grunseg.bitacora.apirest.models.entity.Persona;
import com.grunseg.bitacora.apirest.models.entity.TipoPersona;
import com.grunseg.bitacora.apirest.models.services.IPersonaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class PersonaRestController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/personas")
	public List<Persona> all(){
		return personaService.findAll();
	}
	
	@GetMapping("/personas-habilitadas")
	public List<Persona> personasHabilitadas(){
		return personaService.findByEstadoPersonaA();
	}
	
	@GetMapping("/personas-deshabilitadas")
	public List<Persona> personasDeshabilitadas(){
		return personaService.findByEstadoPersonaD();
	}
	
	@GetMapping("/personas/filtrar-cedula/{cedula}")
	@ResponseStatus(HttpStatus.OK)
	public List<Persona> filtrarPersonasCedula(@PathVariable String cedula){
		return personaService.findByCedulaPersona(cedula);
	}
	
	@GetMapping("/personas/filtrar-lote/{lote}")
	@ResponseStatus(HttpStatus.OK)
	public List<Persona> filtrarPersonasLote(@PathVariable String lote){
		return personaService.findByLotePersona(lote);
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/personas/{id}")
	public ResponseEntity<?> show( @PathVariable Long id ) {
		Persona persona = null;
		Map<String, Object> resp = new HashMap<>();
		
		try {
			persona = personaService.findById(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al realizar la consulta con la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (persona == null) {
			resp.put("msg", "La persona con el id: ".concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	
	@PostMapping("/personas")
	public ResponseEntity<?> create( @Valid @RequestBody Persona persona, BindingResult result ) {
		Persona personaNew = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			personaNew = personaService.save(persona);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "La persona ha sido creada con éxito!");
		response.put("persona", personaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/personas/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Persona persona, BindingResult result, @PathVariable Long id) {
		Persona personaActual = personaService.findById(id);
		Persona personaUpdated = null;
		Map<String, Object> resp = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			resp.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
		}

		if (personaActual == null) {
			resp.put("msg", "Error: No se puede editar la persona con el id: "
					.concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}
		
		try {
		personaActual.setLote(persona.getLote());
		personaActual.setRazonSocial(persona.getRazonSocial());
		personaActual.setCedula(persona.getCedula());
		personaActual.setNombre(persona.getNombre());
		personaActual.setApellido(persona.getApellido());
		personaActual.setTelefono(persona.getTelefono());
		personaActual.setAntecedentes(persona.getAntecedentes());
		personaActual.setObservacion(persona.getObservacion());
		personaActual.setEstado(persona.getEstado());
		personaActual.setFechaActualizacion(persona.getFechaActualizacion());
		personaActual.setEmail(persona.getEmail());
		personaActual.setTipoPersona(persona.getTipoPersona());
		
		personaUpdated = personaService.save(personaActual);
		
		} catch (DataAccessException e) {
			resp.put("msg", "Error al actualizar la persona en la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "La persona a sido actualizado con exito");
		resp.put("persona", personaUpdated);

		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/personas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> resp = new HashMap<>();
		try {
			personaService.delete(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al eliminar la persona en la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "La persona a sido eliminada con exito!");
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);

	}
	
	//@Secured({"ROLE_ADMIN"})
	@GetMapping("/personas/tiposPersonas")
	public List<TipoPersona> listarTiposPersonas(){
		return personaService.findAllTiposPersonas();
	}
	
	
}
