package com.example.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class SalaDT {
    private Long idsala;

    private String Nombresala;

    private String Descripcionsala;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name="area_id")
    @JsonProperty(access=Access.WRITE_ONLY)
    private Areas areasala;
}
