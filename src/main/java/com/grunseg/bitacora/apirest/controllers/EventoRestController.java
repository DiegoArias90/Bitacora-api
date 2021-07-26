package com.grunseg.bitacora.apirest.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grunseg.bitacora.apirest.models.entity.Evento;
import com.grunseg.bitacora.apirest.models.entity.TipoEvento;
import com.grunseg.bitacora.apirest.models.services.IPersonaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class EventoRestController {

	@Autowired
	private IPersonaService personaService;
	
	private final Logger log = LoggerFactory.getLogger(EventoRestController.class);

	@GetMapping("/eventos")
	public List<Evento> all() {
		return personaService.findAllEventos();
	}

	@GetMapping("/eventos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Evento evento = null;
		Map<String, Object> resp = new HashMap<>();

		try {
			evento = personaService.findEventoById(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al realizar la consulta con la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (evento == null) {
			resp.put("msg", "El evento con el id: ".concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Evento>(evento, HttpStatus.OK);
	}

	@PostMapping("/eventos")
	public ResponseEntity<?> create(@Valid @RequestBody Evento evento, BindingResult result) {
		Evento eventoNew = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			eventoNew = personaService.saveEvento(evento);
		} catch (DataAccessException e) {
			response.put("msg", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("msg", "El evento ha sido creado con éxito!");
		response.put("evento", eventoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/eventos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Evento evento, BindingResult result, @PathVariable Long id) {
		Evento eventoActual = personaService.findEventoById(id);
		Evento eventoUpdated = null;
		Map<String, Object> resp = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			resp.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
		}

		if (eventoActual == null) {
			resp.put("msg", "Error: No se puede editar el evento con el id: "
					.concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NOT_FOUND);
		}

		try {
			eventoActual.setResponsable(evento.getResponsable());
			eventoActual.setFechaCreacion(evento.getFechaCreacion());
			eventoActual.setFechaFinalizacion(evento.getFechaFinalizacion());
			eventoActual.setHoraInicio(evento.getHoraInicio());
			eventoActual.setHoraFinalizacion(evento.getHoraFinalizacion());
			eventoActual.setDetalle(evento.getDetalle());
			eventoActual.setNovedad(evento.getNovedad());
			eventoActual.setEstado(evento.getEstado());
			eventoActual.setNumeroInvitado(evento.getNumeroInvitado());
			eventoActual.setTipoEvento(evento.getTipoEvento());

			eventoUpdated = personaService.saveEvento(eventoActual);

		} catch (DataAccessException e) {
			resp.put("msg", "Error al actualizar el evento en la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "El evento a sido actualizado con exito");
		resp.put("evento", eventoUpdated);

		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.CREATED);
	}

	@DeleteMapping("/eventos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> resp = new HashMap<>();
		try {
			Evento evento = personaService.findEventoById(id);
			String listaInvitadosAnterior = evento.getListaInvitado();
			if (listaInvitadosAnterior != null && listaInvitadosAnterior.length() > 0) {
				Path rutaListaInvitadosAnterior = Paths.get("uploads").resolve(listaInvitadosAnterior).toAbsolutePath();
				File archivoLitaInvitadosAnterior = rutaListaInvitadosAnterior.toFile();
				if (archivoLitaInvitadosAnterior.exists() && archivoLitaInvitadosAnterior.canRead()) {
					archivoLitaInvitadosAnterior.delete();
				}
			}
			personaService.deleteEventoById(id);
		} catch (DataAccessException e) {
			resp.put("msg", "Error al eliminar el evento en la BD");
			resp.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		resp.put("msg", "El evento a sido eliminado con exito!");
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);

	}

	@GetMapping("/eventos/tiposEventos")
	public List<TipoEvento> listarTiposEventos() {
		return personaService.findAllTiposEventos();
	}

	@PostMapping("/eventos/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
		Map<String, Object> resp = new HashMap<>();

		Evento evento = personaService.findEventoById(id);

		if (!archivo.isEmpty()) {
			String listaInvitados = "evento_lote_" + evento.getPersona().getLote() + "_" + archivo.getOriginalFilename().replace(" ", "");

			Path rutaArchivo = Paths.get("uploads").resolve(listaInvitados).toAbsolutePath();
			log.info(rutaArchivo.toString());
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				resp.put("msg", "Error al subir listado de invitados del evento");
				resp.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			String listaInvitadosAnterior = evento.getListaInvitado();
			if (listaInvitadosAnterior != null && listaInvitadosAnterior.length() > 0) {
				Path rutaListaInvitadosAnterior = Paths.get("uploads").resolve(listaInvitadosAnterior).toAbsolutePath();
				File archivoLitaInvitadosAnterior = rutaListaInvitadosAnterior.toFile();
				if (archivoLitaInvitadosAnterior.exists() && archivoLitaInvitadosAnterior.canRead()) {
					archivoLitaInvitadosAnterior.delete();
				}
			}

			evento.setListaInvitado(listaInvitados);
			personaService.saveEvento(evento);

			resp.put("evento", evento);
			resp.put("msg", "La lista de invitados a sido subida correctamente: " + listaInvitados);

		}
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.CREATED);

	}

	@GetMapping("/uploads/archivo/{nombreArchivo:.+}")
	public ResponseEntity<Resource> verArchivo(@PathVariable String nombreArchivo) {
		Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
		log.info(rutaArchivo.toString());
		Resource recurso = null;

		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		if (!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se puedo cargar el archivo: " + nombreArchivo);
		}

		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);

	}

}
