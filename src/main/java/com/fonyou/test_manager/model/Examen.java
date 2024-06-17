package com.fonyou.test_manager.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pregunta> preguntas;

    private int puntajeTotal;

    // Constructor, getters y setters
    public Examen() {}

    public Examen(List<Pregunta> preguntas, int puntajeTotal) {
        this.preguntas = preguntas;
        this.puntajeTotal = puntajeTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
}