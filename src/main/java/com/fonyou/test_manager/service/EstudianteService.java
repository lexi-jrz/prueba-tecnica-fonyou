package com.fonyou.test_manager.service;

import com.fonyou.test_manager.model.Estudiante;
import java.util.List;

public interface EstudianteService {
    Estudiante crearEstudiante(Estudiante estudiante);
    List<Estudiante> obtenerTodosLosEstudiantes();
    Estudiante obtenerEstudiantePorId(Long id);
}
