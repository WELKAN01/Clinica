package com.example.demo.Service;

import java.util.List;


import com.example.demo.Entity.Areas;

public interface AreaService {
    //se crea los servicios en el interfaz para llamarlos en la implementacion
    Areas GuardarArea(Areas areas);
    List<Areas> ListaArea();
    Areas BuscarArea(Long id);
    void DeleteArea(Long id);
}
