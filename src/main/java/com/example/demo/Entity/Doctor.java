package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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

    @Column(name="doc_fecha_funcion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_funcion;
    @Column(name="doc_foto")
    private String foto;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="fk_area_id")
    @JsonProperty(access=Access.WRITE_ONLY)
    private Areas areas;
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

    public Areas getAreas() {
        return areas;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }
    

    
    // public Doctor() {
    // }
    // public Doctor(Long id, String nombre, String apellido, String dNI, Date fecha_funcion, String foto) {
    //     this.id = id;
    //     this.nombre = nombre;
    //     this.apellido = apellido;
    //     DNI = dNI;
    //     this.fecha_funcion = fecha_funcion;
    //     this.foto = foto;
    // }

    
    
    
}
