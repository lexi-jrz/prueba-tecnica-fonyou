package com.fonyou.test_manager.controller;

import com.fonyou.test_manager.model.Respuesta;
import com.fonyou.test_manager.service.RespuestaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    private final RespuestaService respuestaService;

    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @PostMapping
    public ResponseEntity<Respuesta> guardarRespuesta(@RequestBody Respuesta respuesta) {
        return ResponseEntity.ok(respuestaService.guardarRespuesta(respuesta));
    }

    @GetMapping("/examen/{examenId}/estudiante/{estudianteId}")
    public ResponseEntity<List<Respuesta>> obtenerRespuestasPorExamenYEstudiante(
            @PathVariable Long examenId, @PathVariable Long estudianteId) {
        return ResponseEntity.ok(respuestaService.obtenerRespuestasPorExamenYEstudiante(examenId, estudianteId));
    }

    @GetMapping("/calificar/examen/{examenId}/estudiante/{estudianteId}")
    public ResponseEntity<Double> calificarExamen(@PathVariable Long examenId, @PathVariable Long estudianteId) {
        return ResponseEntity.ok(respuestaService.calificarExamen(examenId, estudianteId));
    }
}

