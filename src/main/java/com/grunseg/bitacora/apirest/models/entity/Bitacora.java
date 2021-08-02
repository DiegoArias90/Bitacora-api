package com.grunseg.bitacora.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bitacora")
public class Bitacora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Column(name = "hora_ingreso")
	@Temporal(TemporalType.TIME)
	private Date horaIngreso;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Column(name = "hora_salida")
	@Temporal(TemporalType.TIME)
	private Date horaSalida;

	@Column(name = "acompaniante")
	private String acompaniante;

	private String novedad;

	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "autorizado_por")
	private String autorizadoPor;

	@Column(name = "tipo_bitacora")
	@NotEmpty(message = "no puede estar vacio")
	private String tipoBitacora;

	@NotNull(message = "debe estar seleccionada alguna opción")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motivo_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Motivo motivo;

	@NotNull(message = "debe estar seleccionada alguna opción")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Persona persona;

	@NotNull(message = "debe estar seleccionada alguna opción")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visitante_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Visitante visitante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehiculoVisitante_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private VehiculoVisitante vehiculoVisitante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;

	@JsonIgnoreProperties(value = { "bitacora", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bitacora", cascade = CascadeType.ALL)
	private List<AcompaniantesVisitante> acompaniantes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@PrePersist
	public void prePersist() {
		fechaCreacion = new Date();
		horaIngreso = new Date();
	}

	public Bitacora() {
		this.acompaniantes = new ArrayList<AcompaniantesVisitante>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(Date horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getAcompaniante() {
		return acompaniante;
	}

	public void setAcompaniante(String acompaniante) {
		this.acompaniante = acompaniante;
	}

	public String getNovedad() {
		return novedad;
	}

	public void setNovedad(String novedad) {
		this.novedad = novedad;
	}

	public String getAutorizadoPor() {
		return autorizadoPor;
	}

	public void setAutorizadoPor(String autorizadoPor) {
		this.autorizadoPor = autorizadoPor;
	}

	public String getTipoBitacora() {
		return tipoBitacora;
	}

	public void setTipoBitacora(String tipoBitacora) {
		this.tipoBitacora = tipoBitacora;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public VehiculoVisitante getVehiculoVisitante() {
		return vehiculoVisitante;
	}

	public void setVehiculoVisitante(VehiculoVisitante vehiculoVisitante) {
		this.vehiculoVisitante = vehiculoVisitante;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<AcompaniantesVisitante> getAcompaniantes() {
		return acompaniantes;
	}

	public void setAcompaniantes(List<AcompaniantesVisitante> acompaniantes) {
		this.acompaniantes = acompaniantes;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
