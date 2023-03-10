package com.example.demo.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="area")
public class Areas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Area_id")
    private Long area_id;

    @Column(name="Area_Nombre")
    private String Nombre_Area;

    @Column(name="Area_descripcion")
    private String descripcion;

    @OneToMany(mappedBy="areas", cascade=CascadeType.ALL)
	private List<Doctor> doctores;

    @OneToMany(mappedBy = "areasala", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("areasala")
    private List<Sala> salas;

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
    // public Long getArea_id() {
    //     return area_id;
    // }
    // public void setArea_id(Long area_id) {
    //     this.area_id = area_id;
    // }
    public Long getArea_id() {
        return area_id;
    }
    public void setArea_id(Long area_id) {
        this.area_id = area_id;
    }
    // public List<Doctor> getDoctores() {
    //     return doctores;
    // }
    // public void setDoctores(List<Doctor> doctores) {
    //     this.doctores = doctores;
    // }


    public List<Doctor> getDoctores() {
        return doctores;
    }


    public void setDoctores(List<Doctor> doctores) {
        this.doctores = doctores;
    }
    public List<Sala> getSalas() {
        return salas;
    }
    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
    
        
    

}
