package com.fonyou.test_manager.service.impl;

import com.fonyou.test_manager.model.Asignacion;
import com.fonyou.test_manager.model.Estudiante;
import com.fonyou.test_manager.model.Examen;
import com.fonyou.test_manager.repository.AsignacionRepository;
import com.fonyou.test_manager.repository.EstudianteRepository;
import com.fonyou.test_manager.repository.ExamenRepository;
import com.fonyou.test_manager.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class AsignacionServiceImpl implements AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public Asignacion asignarFechaExamen(Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }

    @Override
    public List<Asignacion> obtenerAsignacionesPorEstudiante(Long estudianteId) {
        return asignacionRepository.findByEstudianteId(estudianteId);
    }

    @Override
    public Asignacion asignarExamen(Long estudianteId, Long examenId, LocalDateTime fechaExamen) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        Examen examen = examenRepository.findById(examenId)
                .orElseThrow(() -> new IllegalArgumentException("Examen no encontrado"));

        ZoneId zoneIdBogota = ZoneId.of("America/Bogota");
        ZonedDateTime fechaExamenBogota = fechaExamen.atZone(zoneIdBogota);
        ZoneId zonaHorariaEstudiante = ZoneId.of(estudiante.getZonaHoraria());
        ZonedDateTime fechaExamenEstudiante = fechaExamenBogota.withZoneSameInstant(zonaHorariaEstudiante);

        Asignacion asignacion = new Asignacion();
        asignacion.setEstudiante(estudiante);
        asignacion.setExamen(examen);
        asignacion.setFechaExamen(fechaExamenEstudiante.toLocalDateTime());

        return asignacionRepository.save(asignacion);
    }
}

