package org.educoreapi.educoreapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class RegistroEstudiante {

    @Id
    private Integer id;
    private String nombreEstudiante;
    private String curso;
    private boolean activo;
    private LocalDate fechaRegistro;

    public RegistroEstudiante(){}

    public RegistroEstudiante(Integer id, String nombreEstudiante, String curso, boolean activo) {
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.curso = curso;
        this.activo = activo;
        this.fechaRegistro = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
}
