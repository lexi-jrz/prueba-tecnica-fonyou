package com.fonyou.test_manager.controller;

import com.fonyou.test_manager.model.Asignacion;
import com.fonyou.test_manager.service.AsignacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    private final AsignacionService asignacionService;

    public AsignacionController(AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @PostMapping
    public ResponseEntity<Asignacion> asignarFechaExamen(@RequestBody Asignacion asignacion) {
        return ResponseEntity.ok(asignacionService.asignarFechaExamen(asignacion));
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<Asignacion>> obtenerAsignacionesPorEstudiante(@PathVariable Long estudianteId) {
        return ResponseEntity.ok(asignacionService.obtenerAsignacionesPorEstudiante(estudianteId));
    }
}

