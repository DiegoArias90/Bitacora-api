package com.grunseg.bitacora.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "eventos")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String responsable;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	@Column(name = "fecha_finalizacion")
	@Temporal(TemporalType.DATE)
	private Date fechaFinalizacion;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Column(name = "hora_inicio")
	@Temporal(TemporalType.TIME)
	private Date horaInicio;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Column(name = "hora_finalizacion")
	@Temporal(TemporalType.TIME)
	private Date horaFinalizacion;

	private String detalle;

	private String novedad;

	private Boolean estado;

	@Column(name = "numero_invitado")
	private Integer numeroInvitado;

	@Column(name = "lista_invitado")
	private String listaInvitado;

	@JsonIgnoreProperties(value = { "eventos", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Persona persona;

	@NotNull(message = "debe estar seleccionada alguna opción")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_evento_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoEvento tipoEvento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFinalizacion() {
		return horaFinalizacion;
	}

	public void setHoraFinalizacion(Date horaFinalizacion) {
		this.horaFinalizacion = horaFinalizacion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getNovedad() {
		return novedad;
	}

	public void setNovedad(String novedad) {
		this.novedad = novedad;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getNumeroInvitado() {
		return numeroInvitado;
	}

	public void setNumeroInvitado(Integer numeroInvitado) {
		this.numeroInvitado = numeroInvitado;
	}

	public String getListaInvitado() {
		return listaInvitado;
	}

	public void setListaInvitado(String listaInvitado) {
		this.listaInvitado = listaInvitado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

}
