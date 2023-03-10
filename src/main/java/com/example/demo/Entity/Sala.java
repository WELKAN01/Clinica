package com.example.demo.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="sala")
public class Sala implements Serializable{
    @Id
    @Column(name="id_sala")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsala;

    @Column(name="Nombre_sala")
    private String Nombresala;

    @Column(name="Descripcion_sala")
    private String Descripcionsala;

    
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name="area_id")
    // @JsonProperty(access=Access.WRITE_ONLY)
    @JsonIgnoreProperties("salas")
    private Areas areasala;

    public Long getIdsala() {
        return idsala;
    }

    public void setIdsala(Long idsala) {
        this.idsala = idsala;
    }

    public String getNombresala() {
        return Nombresala;
    }

    public void setNombresala(String nombresala) {
        Nombresala = nombresala;
    }

    public String getDescripcionsala() {
        return Descripcionsala;
    }

    public void setDescripcionsala(String descripcionsala) {
        Descripcionsala = descripcionsala;
    }

    public Areas getAreasala() {
        return areasala;
    }

    public void setAreasala(Areas areasala) {
        this.areasala = areasala;
    }

    
}
