package com.fonyou.test_manager.controller;

import com.fonyou.test_manager.model.Estudiante;
import com.fonyou.test_manager.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.crearEstudiante(estudiante));
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodosLosEstudiantes() {
        return ResponseEntity.ok(estudianteService.obtenerTodosLosEstudiantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.obtenerEstudiantePorId(id));
    }
}

