package com.fonyou.test_manager.service;

import com.fonyou.test_manager.model.Respuesta;
import java.util.List;

public interface RespuestaService {
    Respuesta guardarRespuesta(Respuesta respuesta);
    List<Respuesta> obtenerRespuestasPorExamenYEstudiante(Long examenId, Long estudianteId);
    double calificarExamen(Long examenId, Long estudianteId);
}
