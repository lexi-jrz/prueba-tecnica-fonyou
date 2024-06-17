package com.fonyou.test_manager.controller;

import com.fonyou.test_manager.model.Examen;
import com.fonyou.test_manager.service.ExamenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examenes")
public class ExamenController {

    private final ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @PostMapping
    public ResponseEntity<Examen> crearExamen(@RequestBody Examen examen) {
        return ResponseEntity.ok(examenService.crearExamen(examen));
    }

    @GetMapping
    public ResponseEntity<List<Examen>> obtenerTodosLosExamenes() {
        return ResponseEntity.ok(examenService.obtenerTodosLosExamenes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> obtenerExamenPorId(@PathVariable Long id) {
        return ResponseEntity.ok(examenService.obtenerExamenPorId(id));
    }
}
