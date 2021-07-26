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

import com.grunseg.bitacora.apirest.models.entity.Empleado;
import com.grunseg.bitacora.apirest.models.entity.TipoEmpleo;
import com.grunseg.bitacora.apirest.models.services.IPersonaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

	@Autowired
	private IPersonaService personaService;

	@GetMapping("/empleados")
	public List<Empleado> all() {
		return personaService.findAllEmpleados();
	}

	@GetMapping("/empleados/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Empleado empleado = null;
		Map<String, Object> resp = new HashMap<>();

		try {
			empleado = personaService.findEmpleadoById(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al realizar la consulta con la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (empleado == null) {
			resp.put("msg", "El empleado con el id: ".concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
	}

	@PostMapping("/empleados")
	public ResponseEntity<?> create(@Valid @RequestBody Empleado empleado, BindingResult result) {
		Empleado empleadoNew = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			empleadoNew = personaService.saveEmpleado(empleado);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "El empleado ha sido creado con éxito!");
		response.put("empleado", empleadoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/empleados/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Empleado empleado, BindingResult result,
			@PathVariable Long id) {
		Empleado empleadoActual = personaService.findEmpleadoById(id);
		Empleado empleadoUpdated = null;
		Map<String, Object> resp = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			resp.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
		}

		if (empleadoActual == null) {
			resp.put("msg", "Error: No se puede editar el empleado con el id: "
					.concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}

		try {
			empleadoActual.setNombre(empleado.getNombre());
			empleadoActual.setApellido(empleado.getApellido());
			empleadoActual.setEstado(empleado.getEstado());
			empleadoActual.setFechaActualizacion(empleado.getFechaActualizacion());
			empleadoActual.setObservacion(empleado.getObservacion());
			empleadoActual.setTipoEmpleo(empleado.getTipoEmpleo());
			empleadoUpdated = personaService.saveEmpleado(empleadoActual);

		} catch (DataAccessException e) {
			resp.put("msg", "Error al actualizar la persona en la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "El empleado a sido actualizado con exito");
		resp.put("empleado", empleadoUpdated);

		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.CREATED);
	}

	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> resp = new HashMap<>();
		try {
			personaService.deleteEmpleadoById(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al eliminar el empleado de la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "El empleado a sido eliminado con exito!");
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);

	}

	@GetMapping("/empleados/tiposEmpleos")
	public List<TipoEmpleo> listarTiposEmpleos() {
		return personaService.findAllTiposEmpleos();
	}

}
