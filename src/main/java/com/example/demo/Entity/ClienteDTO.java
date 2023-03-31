package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class ClienteDTO implements Serializable{
    private Long id;
    private String nombre_apellido;
    private String telefono;
    private Date nacimiento;
    public ClienteDTO() {
    }

    
}
