package com.grunseg.bitacora.apirest.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import com.grunseg.bitacora.apirest.models.entity.Persona;
import com.grunseg.bitacora.apirest.models.entity.Visitante;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Reports {

	public void exportaPersonas(List<Persona> data, Map<String, Object> parametros, String nombrejasper)
			throws JRException, IOException {
		File jasper = new ClassPathResource("/reportes/" + nombrejasper + ".jasper").getFile();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros,
				new JRBeanCollectionDataSource(data));

	}

	public JasperPrint exportaVisitante(List<Visitante> data, Map<String, Object> parametros, String nombrejasper) {

		File jasper;
		JasperPrint jasperPrint = null;
		try {
			jasper = new ClassPathResource("/reports/" + nombrejasper + ".jrxml").getFile();

			JasperReport jasperReport = JasperCompileManager.compileReport(jasper.getPath());
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(data));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jasperPrint;

	}

}
