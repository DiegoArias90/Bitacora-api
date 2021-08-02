package com.grunseg.bitacora.apirest.models.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class ReportService {

	File logo;

	public ReportService() {
		super();
		try {
			logo = new ClassPathResource("/img/logo-ups-home2.png").getFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JasperPrint reporteInscripcionEstudiante() {
		JasperPrint jasperPrint = null;
		Map<String, Object> param = new HashMap();

		List<Object> listauxprsl = new ArrayList<Object>();

		/*
		 * param.put("usuario", "usuario"); param.put("estado", ""); param.put("opcion",
		 * ""); param.put("perfil", ""); param.put("logo", logo.getPath());
		 */

		File jasper;
		try {
			jasper = new ClassPathResource("/reportes/informeGeneral.jrxml").getFile();
			JasperReport jasperReport = JasperCompileManager.compileReport(jasper.getPath());
			jasperPrint = JasperFillManager.fillReport(jasperReport, param);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
		return jasperPrint;
	}

}
