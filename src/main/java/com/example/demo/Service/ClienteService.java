package com.example.demo.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.ClienteDTO;

public interface ClienteService {
    void guardar(Cliente cliente);
    Cliente guardarAPI(Cliente cliente);
    List<Cliente> buscarcliente(String nombre);
    List<ClienteDTO> listclienteDTO();
    Page<Cliente> getAll(Pageable pageable);
    List<Cliente> listar();

}
