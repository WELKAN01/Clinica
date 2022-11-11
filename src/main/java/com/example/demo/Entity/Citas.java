package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="citas")
public class Citas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="citas_id")
    private Long id;
    @JoinColumn (name="doc_id")
    private int cita_doctor;

    @JoinColumn (name="cli_id")
    @Column(name="citas_cliente")
    private int cita_aliente;
    
    @JoinColumn (name="Area_id")
    @Column(name="citas_areas")
    private int cita_area;

    @Column(name="citas_descripcion")
    private String descripcion;

    @Column(name="programacion")
    @DateTimeFormat(pattern = "DD/mm/YYY HH:mm:ss")
    private Date fecha_programacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCita_doctor() {
        return cita_doctor;
    }

    public void setCita_doctor(int cita_doctor) {
        this.cita_doctor = cita_doctor;
    }

    public int getCita_aliente() {
        return cita_aliente;
    }

    public void setCita_aliente(int cita_aliente) {
        this.cita_aliente = cita_aliente;
    }

    public int getCita_area() {
        return cita_area;
    }

    public void setCita_area(int cita_area) {
        this.cita_area = cita_area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_programacion() {
        return fecha_programacion;
    }

    public void setFecha_programacion(Date fecha_programacion) {
        this.fecha_programacion = fecha_programacion;
    }
    
}
