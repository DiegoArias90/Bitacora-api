package com.grunseg.bitacora.apirest.dto;

import java.io.Serializable;

public class InformeDataDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fechaCreacion;
	private String horaIngreso;
	private String horaSalida;
	private String descripcionVehiculo;
	private String motivo;
	private String tipoBitacora;
	private String visitante;
	private String residente;

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getDescripcionVehiculo() {
		return descripcionVehiculo;
	}

	public void setDescripcionVehiculo(String descripcionVehiculo) {
		this.descripcionVehiculo = descripcionVehiculo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTipoBitacora() {
		return tipoBitacora;
	}

	public void setTipoBitacora(String tipoBitacora) {
		this.tipoBitacora = tipoBitacora;
	}

	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	public String getResidente() {
		return residente;
	}

	public void setResidente(String residente) {
		this.residente = residente;
	}
}
