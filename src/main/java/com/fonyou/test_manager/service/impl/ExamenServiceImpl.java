package com.fonyou.test_manager.service.impl;

import com.fonyou.test_manager.model.Examen;
import com.fonyou.test_manager.model.Pregunta;
import com.fonyou.test_manager.repository.ExamenRepository;
import com.fonyou.test_manager.repository.PreguntaRepository;
import com.fonyou.test_manager.service.ExamenService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExamenServiceImpl implements ExamenService {

    private final ExamenRepository examenRepository;
    private final PreguntaRepository preguntaRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository, PreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Examen crearExamen(Examen examen) {
        int totalPuntos = 0;
        for (Pregunta pregunta : examen.getPreguntas()) {
            totalPuntos += pregunta.getPuntos();
        }
        if (totalPuntos == 100) {
            return examenRepository.save(examen);
        } else {
            throw new IllegalArgumentException("La suma de los puntos de las preguntas debe ser 100");
        }
    }

    @Override
    public List<Examen> obtenerTodosLosExamenes() {
        return examenRepository.findAll();
    }

    @Override
    public Examen obtenerExamenPorId(Long id) {
        return examenRepository.findById(id).orElse(null);
    }

	public PreguntaRepository getPreguntaRepository() {
		return preguntaRepository;
	}
}
