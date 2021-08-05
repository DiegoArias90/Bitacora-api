package com.grunseg.bitacora.apirest.models.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.grunseg.bitacora.apirest.dto.InformeDataDTO;
import com.grunseg.bitacora.apirest.models.entity.Bitacora;
import com.grunseg.bitacora.apirest.util.Reports;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	private IBitacoraService bitacoraService;

	File logo;

	public ReportService() {
		super();
		try {
			logo = new ClassPathResource("/img/invoice_logo.png").getFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JasperPrint reporteGeneral(Date fechaInicio, Date fechaFin, Long empresaId) {
		JasperPrint jasperPrint = null;
		Map<String, Object> param = new HashMap();

		List<Bitacora> listBitacora = bitacoraService.findByFechaEntrada(fechaInicio, fechaFin, empresaId);
		String subtitulo = "FECHA INICIO: ".concat(Reports.parseFecha(fechaInicio, "dd/MM/yyyy"))
				.concat(" - FECHA FIN:").concat(Reports.parseFecha(fechaFin, "dd/MM/yyyy"));
		param.put("titulo", "INFORME GENERAL DE ENTRADA Y SALIDAS GENERADAS POR PERIODO");
		param.put("subtitulo", subtitulo);
		param.put("logo", logo.getPath());

		List<InformeDataDTO> listData = new ArrayList<InformeDataDTO>();
		if (!listBitacora.isEmpty() && listBitacora != null) {
			for (Bitacora bitacora : listBitacora) {
				InformeDataDTO obj = new InformeDataDTO();
				obj.setFechaCreacion(Reports.parseFecha(bitacora.getFechaCreacion(), "dd/MM/yyyy"));
				obj.setHoraIngreso(Reports.parseFecha(bitacora.getHoraIngreso(), "hh:mm:ss"));
				obj.setDescripcionVehiculo(
						bitacora.getVehiculoVisitante() != null ? bitacora.getVehiculoVisitante().toString() : "");
				obj.setMotivo(bitacora.getMotivo().getDetalle());
				obj.setTipoBitacora(bitacora.getTipoBitacora());
				obj.setVisitante(bitacora.getVisitante().getNombre());
				obj.setResidente(bitacora.getPersona().getApellido() + " " + bitacora.getPersona().getNombre());
				listData.add(obj);
			}

		}

		File jasper;
		try {
			jasper = new ClassPathResource("/reportes/informeGeneral.jrxml").getFile();
			JasperReport jasperReport = JasperCompileManager.compileReport(jasper.getPath());
			jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JRBeanCollectionDataSource(listData));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
		return jasperPrint;
	}

	public JasperPrint reportePropietario(Date fechaInicio, Date fechaFin, Long empresaId, Long idPropietario) {
		JasperPrint jasperPrint = null;
		Map<String, Object> param = new HashMap();

		List<Bitacora> listBitacora = bitacoraService.findByFechaEntradaAndIdPropietario(fechaInicio, fechaFin,
				empresaId, idPropietario);
		String subtitulo = "FECHA INICIO: ".concat(Reports.parseFecha(fechaInicio, "dd/MM/yyyy"))
				.concat(" - FECHA FIN:").concat(Reports.parseFecha(fechaFin, "dd/MM/yyyy"));
		param.put("titulo", "INFORME VISITAS GENERADAS POR PERIODO");
		param.put("subtitulo", subtitulo);
		param.put("logo", logo.getPath());

		List<InformeDataDTO> listData = new ArrayList<InformeDataDTO>();
		if (!listBitacora.isEmpty() && listBitacora != null) {
			String subtitulo2 = "PROPIETARIO: ".concat(listBitacora.get(0).getPersona().getApellido() + " "
					+ listBitacora.get(0).getPersona().getNombre());
			param.put("subtitulo2", subtitulo2);
			for (Bitacora bitacora : listBitacora) {
				InformeDataDTO obj = new InformeDataDTO();
				obj.setFechaCreacion(Reports.parseFecha(bitacora.getFechaCreacion(), "dd/MM/yyyy"));
				obj.setHoraIngreso(Reports.parseFecha(bitacora.getHoraIngreso(), "hh:mm:ss"));
				obj.setDescripcionVehiculo(
						bitacora.getVehiculoVisitante() != null ? bitacora.getVehiculoVisitante().toString() : "");
				obj.setMotivo(bitacora.getMotivo().getDetalle());
				obj.setTipoBitacora(bitacora.getTipoBitacora());
				obj.setVisitante(bitacora.getVisitante().getNombre());
				obj.setResidente(bitacora.getPersona().getApellido() + " " + bitacora.getPersona().getNombre());
				listData.add(obj);
			}

		}

		File jasper;
		try {
			jasper = new ClassPathResource("/reportes/informePropietario.jrxml").getFile();
			JasperReport jasperReport = JasperCompileManager.compileReport(jasper.getPath());
			jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JRBeanCollectionDataSource(listData));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
		return jasperPrint;
	}

	public JasperPrint reporteVehiculo(Date fechaInicio, Date fechaFin, Long empresaId, String placa) {
		JasperPrint jasperPrint = null;
		Map<String, Object> param = new HashMap();

		List<Bitacora> listBitacora = bitacoraService.findByFechaEntradaAndPlaca(fechaInicio, fechaFin, empresaId,
				placa);
		String subtitulo = "FECHA INICIO: ".concat(Reports.parseFecha(fechaInicio, "dd/MM/yyyy"))
				.concat(" - FECHA FIN:").concat(Reports.parseFecha(fechaFin, "dd/MM/yyyy"));
		param.put("titulo", "INFORME VISITAS GENERADAS POR PERIODO");
		param.put("subtitulo", subtitulo);
		param.put("logo", logo.getPath());

		List<InformeDataDTO> listData = new ArrayList<InformeDataDTO>();
		if (!listBitacora.isEmpty() && listBitacora != null) {
			String subtitulo2 = "PLACA: ".concat(placa);
			param.put("subtitulo2", subtitulo2);
			for (Bitacora bitacora : listBitacora) {
				InformeDataDTO obj = new InformeDataDTO();
				obj.setFechaCreacion(Reports.parseFecha(bitacora.getFechaCreacion(), "dd/MM/yyyy"));
				obj.setHoraIngreso(Reports.parseFecha(bitacora.getHoraIngreso(), "hh:mm:ss"));
				obj.setDescripcionVehiculo(
						bitacora.getVehiculoVisitante() != null ? bitacora.getVehiculoVisitante().toString() : "");
				obj.setMotivo(bitacora.getMotivo().getDetalle());
				obj.setTipoBitacora(bitacora.getTipoBitacora());
				obj.setVisitante(bitacora.getVisitante().getNombre());
				obj.setResidente(bitacora.getPersona().getApellido() + " " + bitacora.getPersona().getNombre());
				listData.add(obj);
			}

		}

		File jasper;
		try {
			jasper = new ClassPathResource("/reportes/informeVehiculo.jrxml").getFile();
			JasperReport jasperReport = JasperCompileManager.compileReport(jasper.getPath());
			jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JRBeanCollectionDataSource(listData));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
		return jasperPrint;
	}

}
