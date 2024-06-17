package com.fonyou.test_manager.service;

import com.fonyou.test_manager.model.Asignacion;

import java.time.LocalDateTime;
import java.util.List;

public interface AsignacionService {
    Asignacion asignarFechaExamen(Asignacion asignacion);
    List<Asignacion> obtenerAsignacionesPorEstudiante(Long estudianteId);
    Asignacion asignarExamen(Long estudianteId, Long examenId, LocalDateTime fechaExamen);
}
