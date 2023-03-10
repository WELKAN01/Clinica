package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.Sala;

public interface SalasService {
    List<Sala> ListSalas();
    Sala GuardarSala(Sala sala);
    void EliminarSala(Long id);
}
