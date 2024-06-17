package com.fonyou.test_manager.service;

import com.fonyou.test_manager.model.Examen;
import java.util.List;

public interface ExamenService {
    Examen crearExamen(Examen examen);
    List<Examen> obtenerTodosLosExamenes();
    Examen obtenerExamenPorId(Long id);
}

