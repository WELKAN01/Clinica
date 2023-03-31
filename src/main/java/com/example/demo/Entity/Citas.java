package com.example.demo.Entity;

import java.io.Serializable;
import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.TypeResolutionStrategy.Lazy;

@Setter
@Getter
@Entity
@Table(name="citas")
public class Citas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="citas_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="citas_cliente")
    Cliente cita_cliente;
    
    @ManyToOne
    @JoinColumn(name="citas_areas")
    Areas cita_area;

    @ManyToOne
    @JoinColumn (name="cita_doctor")
    Doctor cita_doctor;

    @Column(name="programacion")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date fecha_programacion;

    @Column(name="citas_descripcion")
    private String descripcion;
}
