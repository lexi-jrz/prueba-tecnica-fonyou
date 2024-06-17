package com.fonyou.test_manager.model;

import jakarta.persistence.*;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int edad;
    private String ciudad;
    private String zonaHoraria;

    // Constructor, getters y setters
    public Estudiante() {}

    public Estudiante(String nombre, int edad, String ciudad, String zonaHoraria) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.zonaHoraria = zonaHoraria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }
}