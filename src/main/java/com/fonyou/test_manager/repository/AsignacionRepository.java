package com.fonyou.test_manager.repository;

import com.fonyou.test_manager.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
    List<Asignacion> findAllByEstudianteId(Long estudianteId);

	List<Asignacion> findByEstudianteId(Long estudianteId);
}
