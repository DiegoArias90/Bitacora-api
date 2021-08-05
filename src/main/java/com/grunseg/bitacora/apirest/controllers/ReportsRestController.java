package com.grunseg.bitacora.apirest.controllers;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grunseg.bitacora.apirest.dto.InformeFiltroDTO;
import com.grunseg.bitacora.apirest.models.services.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ReportsRestController {

	@Autowired
	private ReportService reportService;

	// @GetMapping("/reporteGeneral")
	@RequestMapping(value = "/reporteGeneral", method = RequestMethod.GET, consumes = { "application/json" })
	public void reporteGeneral(HttpServletResponse response, @RequestBody InformeFiltroDTO consulta)
			throws IOException, JRException {
		JasperPrint jasperPrint = null;
		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"rptGeneral.pdf\""));
		OutputStream out = response.getOutputStream();
		jasperPrint = reportService.reporteGeneral(consulta.getFechaInicio(), consulta.getFechaFin(),
				consulta.getEmpresaId());
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}

	@RequestMapping(value = "/reportePropietario", method = RequestMethod.GET, consumes = { "application/json" })
	public void reportePropietario(HttpServletResponse response, @RequestBody InformeFiltroDTO consulta)
			throws IOException, JRException {
		JasperPrint jasperPrint = null;
		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"rptPropietario.pdf\""));
		OutputStream out = response.getOutputStream();
		jasperPrint = reportService.reportePropietario(consulta.getFechaInicio(), consulta.getFechaFin(),
				consulta.getEmpresaId(), consulta.getIdPropietario());
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}

	@RequestMapping(value = "/reporteVehiculo", method = RequestMethod.GET, consumes = { "application/json" })
	public void reporteVehiculo(HttpServletResponse response, @RequestBody InformeFiltroDTO consulta)
			throws IOException, JRException {
		JasperPrint jasperPrint = null;
		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"rptVehiculo.pdf\""));
		OutputStream out = response.getOutputStream();
		jasperPrint = reportService.reporteVehiculo(consulta.getFechaInicio(), consulta.getFechaFin(),
				consulta.getEmpresaId(), consulta.getPlacaVehiculo());
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}

}
