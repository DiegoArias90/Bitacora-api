package com.grunseg.bitacora.apirest.models.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.grunseg.bitacora.apirest.models.entity.Bitacora;
import com.grunseg.bitacora.apirest.util.Reports;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportsService {
	
	
	@Autowired
	private IBitacoraService bitacoraService;
	
	File logo;
	
	Reports rpt = new Reports();
	

	/*public ReportsService() {
		try {
			logo = new ClassPathResource("/img/logo-ups-home2.png").getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	
	public JasperPrint reporteGenaral(String usuario, List<Bitacora> listado) {
		JasperPrint jasperPrint = null;
		Map<String, Object> param = new HashMap();
				
		param.put("usuario", usuario);
		param.put("estado", "");
		param.put("opcion", "");
		param.put("perfil", "");
		//param.put("logo", logo.getPath());

		File jasper;
		try {
			jasper = new ClassPathResource("/reportes/rptPresolicitudListado.jrxml").getFile();
			JasperReport jasperReport = JasperCompileManager.compileReport(jasper.getPath());		
			jasperPrint = JasperFillManager.fillReport(jasperReport, param,
					new JRBeanCollectionDataSource(listado));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}		
		return jasperPrint;
	}
	
	public JasperPrint reportePorPersona(Long idPersona, String usuario) {
		JasperPrint jasperPrint = null;
		Map<String, Object> param = new HashMap();
		
		List<Bitacora> listauxprsl = new ArrayList<Bitacora>();
		listauxprsl.add(bitacoraService.findById(idPersona));				
		
		param.put("usuario", usuario);
		param.put("estado", "");
		param.put("opcion", "");
		param.put("perfil", "");
		//param.put("logo", logo.getPath());

		File jasper;
		try {
			jasper = new ClassPathResource("/reportes/rptPresolicitudEstudiante.jrxml").getFile();
			JasperReport jasperReport = JasperCompileManager.compileReport(jasper.getPath());		
			jasperPrint = JasperFillManager.fillReport(jasperReport, param,
					new JRBeanCollectionDataSource(listauxprsl));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}		
		return jasperPrint;
	}
	
	
	
	public JasperPrint reporteVehiculo(String usuario, List<Bitacora> listado) {
		JasperPrint jasperPrint = null;
		Map<String, Object> param = new HashMap();
				
		param.put("usuario", usuario);
		param.put("estado", "");
		param.put("opcion", "");
		param.put("perfil", "");
		//param.put("logo", logo.getPath());

		File jasper;
		try {
			jasper = new ClassPathResource("/reportes/rptPresolicitudListado.jrxml").getFile();
			JasperReport jasperReport = JasperCompileManager.compileReport(jasper.getPath());		
			jasperPrint = JasperFillManager.fillReport(jasperReport, param,
					new JRBeanCollectionDataSource(listado));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}		
		return jasperPrint;
	}
	
	
	

}
