package com.example.demo.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="area")
public class Areas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Area_id")
    private Long id;
    @Column(name="Nombre_Area")
    private String Nombre_Area;
    @Column(name="descripcion_Area")
    private String descripcion;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre_Area() {
        return Nombre_Area;
    }
    public void setNombre_Area(String nombre_Area) {
        Nombre_Area = nombre_Area;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
