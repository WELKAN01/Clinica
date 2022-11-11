package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="doctor")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doc_id")
    private Long id;
    @Column(name="doc_nombre")
    private String nombre;
    @Column(name="doc_apellido")
    private String apellido;
    @Column(name="doc_DNI")
    private String DNI;
    @DateTimeFormat(pattern = "DD/mm/YYYY")
    @Column(name="doc_fecha_funcion")
    private Date fecha_funcion;
    @Column(name="doc_foto")
    private String foto;

    @JoinColumn(name="Area_id")
    @ManyToOne
    private Areas Area;

    
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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }
    public Date getFecha_funcion() {
        return fecha_funcion;
    }
    public void setFecha_funcion(Date fecha_funcion) {
        this.fecha_funcion = fecha_funcion;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public Areas getArea() {
        return Area;
    }
    public void setArea(Areas area) {
        this.Area=area;
    }
    
}
