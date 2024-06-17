package com.fonyou.test_manager.repository;

import com.fonyou.test_manager.model.Respuesta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

	@Query("SELECT r FROM Respuesta r WHERE r.examenId = :examenId AND r.estudianteId = :estudianteId")
    List<Respuesta> findAllByExamenIdAndEstudianteId(@Param("examenId") Long examenId, @Param("estudianteId") Long estudianteId);
}
