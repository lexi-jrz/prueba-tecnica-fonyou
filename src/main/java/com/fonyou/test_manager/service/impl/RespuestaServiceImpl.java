package com.fonyou.test_manager.service.impl;

import com.fonyou.test_manager.model.Respuesta;
import com.fonyou.test_manager.repository.PreguntaRepository;
import com.fonyou.test_manager.repository.RespuestaRepository;
import com.fonyou.test_manager.service.RespuestaService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final PreguntaRepository preguntaRepository;

    public RespuestaServiceImpl(RespuestaRepository respuestaRepository, PreguntaRepository preguntaRepository) {
        this.respuestaRepository = respuestaRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Respuesta guardarRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    @Override
    public List<Respuesta> obtenerRespuestasPorExamenYEstudiante(Long examenId, Long estudianteId) {
        return respuestaRepository.findAllByExamenIdAndEstudianteId(examenId, estudianteId);
    }

    @Override
    public double calificarExamen(Long examenId, Long estudianteId) {
        List<Respuesta> respuestas = obtenerRespuestasPorExamenYEstudiante(examenId, estudianteId);
        double puntajeTotal = 0;

        for (Respuesta respuesta : respuestas) {
            if (respuesta.getOpcionSeleccionada().equals(preguntaRepository.findById(respuesta.getPregunta().getId()).orElseThrow().getOpcionCorrecta())) {
                puntajeTotal += respuesta.getPregunta().getPuntos();
            }
        }

        return puntajeTotal;
    }
}
