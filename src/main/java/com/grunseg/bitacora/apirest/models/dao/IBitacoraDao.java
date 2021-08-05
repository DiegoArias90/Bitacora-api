package com.grunseg.bitacora.apirest.models.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grunseg.bitacora.apirest.models.entity.Bitacora;
import com.grunseg.bitacora.apirest.models.entity.Motivo;

public interface IBitacoraDao extends JpaRepository<Bitacora, Long> {

	@Query("from Bitacora where hora_salida is null ORDER BY hora_ingreso DESC")
	public List<Bitacora> findAllBitacoraOrdenada();

	@Query("from Motivo")
	public List<Motivo> findAllMotivos();

	@Query(value = "from Bitacora where empresaId = :idEmpresa AND fechaCreacion BETWEEN :startDate AND :endDate ORDER BY fechaCreacion, horaIngreso")
	public List<Bitacora> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
			@Param("idEmpresa") Long idEmpresa);

	@Query(value = "from Bitacora b where b.persona.id = :idPropietario AND b.empresaId = :idEmpresa AND b.fechaCreacion BETWEEN :startDate AND :endDate ORDER BY b.fechaCreacion, b.horaIngreso")
	public List<Bitacora> getAllBetweenDatesAndIdPropietario(@Param("startDate") Date startDate,
			@Param("endDate") Date endDate, @Param("idEmpresa") Long idEmpresa,
			@Param("idPropietario") Long idPropietario);

	@Query(value = "from Bitacora b where b.vehiculoVisitante.placa = :placa AND b.empresaId = :idEmpresa AND b.fechaCreacion BETWEEN :startDate AND :endDate ORDER BY b.fechaCreacion, b.horaIngreso")
	public List<Bitacora> getAllBetweenDatesAndPlacaVehiculo(@Param("startDate") Date startDate,
			@Param("endDate") Date endDate, @Param("idEmpresa") Long idEmpresa, @Param("placa") String placa);

}
