package com.fonyou.test_manager.model;

import jakarta.persistence.*;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pregunta pregunta;

    private String respuesta;

    // Constructor, getters y setters
    public Respuesta() {}

    public Respuesta(Estudiante estudiante, Pregunta pregunta, String respuesta) {
        this.estudiante = estudiante;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

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

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

	public Object getOpcionSeleccionada() {
		// TODO Auto-generated method stub
		return null;
	}
}