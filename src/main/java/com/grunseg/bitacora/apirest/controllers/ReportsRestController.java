package com.grunseg.bitacora.apirest.controllers;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grunseg.bitacora.apirest.models.services.ReportService;
import com.grunseg.bitacora.apirest.models.services.ReportsService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ReportsRestController {

	@Autowired
	private ReportsService reporteService;
	@Autowired
	private ReportService reportService;

	@GetMapping("/reporteGeneral")
	public void reporteGeneral(HttpServletResponse response) throws IOException, JRException {
		JasperPrint jasperPrint = null;
		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"rptGeneral.pdf\""));
		OutputStream out = response.getOutputStream();
		jasperPrint = reportService.reporteInscripcionEstudiante();
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}

}
