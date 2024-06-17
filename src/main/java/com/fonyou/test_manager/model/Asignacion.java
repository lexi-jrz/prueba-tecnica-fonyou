package com.fonyou.test_manager.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "asignacion") 
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;

    private LocalDateTime fechaExamen;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public LocalDateTime getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(LocalDateTime fechaExamen) {
        this.fechaExamen = fechaExamen;
    }
}
