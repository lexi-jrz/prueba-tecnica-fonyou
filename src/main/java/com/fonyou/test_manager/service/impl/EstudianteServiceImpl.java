package com.fonyou.test_manager.service.impl;

import com.fonyou.test_manager.model.Estudiante;
import com.fonyou.test_manager.repository.EstudianteRepository;
import com.fonyou.test_manager.service.EstudianteService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }
}
