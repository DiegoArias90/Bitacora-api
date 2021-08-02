package com.grunseg.bitacora.apirest.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VehiculoInfoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("codigoVehiculo")
	private Integer codigoVehiculo;
	@JsonProperty("numeroPlaca")
	private String numeroPlaca;
	@JsonProperty("numeroCamvCpn")
	private String numeroCamvCpn;
	@JsonProperty("colorVehiculo1")
	private String colorVehiculo1;
	@JsonProperty("colorVehiculo2")
	private String colorVehiculo2;
	@JsonProperty("cilindraje")
	private Integer cilindraje;
	@JsonProperty("nombreClase")
	private String nombreClase;
	@JsonProperty("descripcionMarca")
	private String descripcionMarca;
	@JsonProperty("descripcionModelo")
	private String descripcionModelo;
	@JsonProperty("anioAuto")
	private Integer anioAuto;
	@JsonProperty("descripcionPais")
	private String descripcionPais;
	@JsonProperty("mensajeMotivoAuto")
	private String mensajeMotivoAuto;
	@JsonProperty("aplicaCuota")
	private Boolean aplicaCuota;
	@JsonProperty("fechaUltimaMatricula")
	private String fechaUltimaMatricula;
	@JsonProperty("fechaCaducidadMatricula")
	private String fechaCaducidadMatricula;
	@JsonProperty("fechaCompraRegistro")
	private String fechaCompraRegistro;
	@JsonProperty("fechaRevision")
	private String fechaRevision;
	@JsonProperty("descripcionCanton")
	private String descripcionCanton;
	@JsonProperty("descripcionServicio")
	private String descripcionServicio;
	@JsonProperty("ultimoAnioPagado")
	private Integer ultimoAnioPagado;
	@JsonProperty("prohibidoEnajenar")
	private String prohibidoEnajenar;
	@JsonProperty("observacion")
	private Object observacion;
	@JsonProperty("estadoExoneracion")
	private String estadoExoneracion;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Integer getCodigoVehiculo() {
		return codigoVehiculo;
	}

	public void setCodigoVehiculo(Integer codigoVehiculo) {
		this.codigoVehiculo = codigoVehiculo;
	}

	public String getNumeroPlaca() {
		return numeroPlaca;
	}

	public void setNumeroPlaca(String numeroPlaca) {
		this.numeroPlaca = numeroPlaca;
	}

	public String getNumeroCamvCpn() {
		return numeroCamvCpn;
	}

	public void setNumeroCamvCpn(String numeroCamvCpn) {
		this.numeroCamvCpn = numeroCamvCpn;
	}

	public String getColorVehiculo1() {
		return colorVehiculo1;
	}

	public void setColorVehiculo1(String colorVehiculo1) {
		this.colorVehiculo1 = colorVehiculo1;
	}

	public String getColorVehiculo2() {
		return colorVehiculo2;
	}

	public void setColorVehiculo2(String colorVehiculo2) {
		this.colorVehiculo2 = colorVehiculo2;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public String getDescripcionMarca() {
		return descripcionMarca;
	}

	public void setDescripcionMarca(String descripcionMarca) {
		this.descripcionMarca = descripcionMarca;
	}

	public String getDescripcionModelo() {
		return descripcionModelo;
	}

	public void setDescripcionModelo(String descripcionModelo) {
		this.descripcionModelo = descripcionModelo;
	}

	public Integer getAnioAuto() {
		return anioAuto;
	}

	public void setAnioAuto(Integer anioAuto) {
		this.anioAuto = anioAuto;
	}

	public String getDescripcionPais() {
		return descripcionPais;
	}

	public void setDescripcionPais(String descripcionPais) {
		this.descripcionPais = descripcionPais;
	}

	public String getMensajeMotivoAuto() {
		return mensajeMotivoAuto;
	}

	public void setMensajeMotivoAuto(String mensajeMotivoAuto) {
		this.mensajeMotivoAuto = mensajeMotivoAuto;
	}

	public Boolean getAplicaCuota() {
		return aplicaCuota;
	}

	public void setAplicaCuota(Boolean aplicaCuota) {
		this.aplicaCuota = aplicaCuota;
	}

	public String getFechaUltimaMatricula() {
		return fechaUltimaMatricula;
	}

	public void setFechaUltimaMatricula(String fechaUltimaMatricula) {
		this.fechaUltimaMatricula = fechaUltimaMatricula;
	}

	public String getFechaCaducidadMatricula() {
		return fechaCaducidadMatricula;
	}

	public void setFechaCaducidadMatricula(String fechaCaducidadMatricula) {
		this.fechaCaducidadMatricula = fechaCaducidadMatricula;
	}

	public String getFechaCompraRegistro() {
		return fechaCompraRegistro;
	}

	public void setFechaCompraRegistro(String fechaCompraRegistro) {
		this.fechaCompraRegistro = fechaCompraRegistro;
	}

	public String getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(String fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public String getDescripcionCanton() {
		return descripcionCanton;
	}

	public void setDescripcionCanton(String descripcionCanton) {
		this.descripcionCanton = descripcionCanton;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public Integer getUltimoAnioPagado() {
		return ultimoAnioPagado;
	}

	public void setUltimoAnioPagado(Integer ultimoAnioPagado) {
		this.ultimoAnioPagado = ultimoAnioPagado;
	}

	public String getProhibidoEnajenar() {
		return prohibidoEnajenar;
	}

	public void setProhibidoEnajenar(String prohibidoEnajenar) {
		this.prohibidoEnajenar = prohibidoEnajenar;
	}

	public Object getObservacion() {
		return observacion;
	}

	public void setObservacion(Object observacion) {
		this.observacion = observacion;
	}

	public String getEstadoExoneracion() {
		return estadoExoneracion;
	}

	public void setEstadoExoneracion(String estadoExoneracion) {
		this.estadoExoneracion = estadoExoneracion;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}