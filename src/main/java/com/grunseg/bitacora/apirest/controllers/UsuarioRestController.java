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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.grunseg.bitacora.apirest.models.entity.Role;
import com.grunseg.bitacora.apirest.models.entity.Usuario;
import com.grunseg.bitacora.apirest.models.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/usuarios")
	public List<Usuario> all(){
		return usuarioService.findAll();
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> show( @PathVariable Long id ) {
		Usuario usuario = null;
		Map<String, Object> resp = new HashMap<>();
		
		try {
			usuario = usuarioService.findById(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al realizar la consulta con la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (usuario == null) {
			resp.put("msg", "El usuario con el id: ".concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> create( @Valid @RequestBody Usuario usuario, BindingResult result ) {
		Usuario usuarioNew = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuarioNew = usuarioService.save(usuario);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "El usuario ha sido creado con éxito!");
		response.put("usuario", usuarioNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id) {
		Usuario usuarioActual = usuarioService.findById(id);
		Usuario usuarioUpdated = null;
		Map<String, Object> resp = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			resp.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
		}

		if (usuarioActual == null) {
			resp.put("msg", "Error: No se puede editar la persona con el id: "
					.concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}
		
		try {
			usuarioActual.setUsername(usuario.getUsername());
			usuarioActual.setCedula(usuario.getCedula());
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setApellido(usuario.getApellido());
			usuarioActual.setTelefono(usuario.getTelefono());
			usuarioActual.setObservacion(usuario.getObservacion());
			usuarioActual.setRoles(usuario.getRoles());
		
			usuarioUpdated = usuarioService.save(usuarioActual);
		
		} catch (DataAccessException e) {
			resp.put("msg", "Error al actualizar el usuario en la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "El usuario a sido actualizado con exito");
		resp.put("usuario", usuarioUpdated);

		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> resp = new HashMap<>();
		try {
			usuarioService.delete(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al eliminar el usuario en la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "el usuario a sido eliminado con exito!");
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);

	}
	
	@GetMapping("/usuarios/roles")
	public List<Role> listarRoles(){
		return usuarioService.findAllRoles();
	}

}
