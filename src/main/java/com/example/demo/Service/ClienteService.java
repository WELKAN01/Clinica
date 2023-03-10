package com.example.demo.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.Cliente;

public interface ClienteService {
    void guardar(Cliente cliente);
    Cliente guardarAPI(Cliente cliente);
    Page<Cliente> getAll(Pageable pageable);
    List<Cliente> listar();

}
