package com.example.demo.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.Cliente;

public interface ClienteService {
    void guardar(Cliente cliente);
    Page<Cliente> getAll(Pageable pageable);

}
