package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.DAO.ClienteDAO;
import com.example.demo.Entity.Cliente;

@Service
public class ClienteImp implements ClienteService{

    @Autowired
    private ClienteDAO CDAO;

    @Override
    public Page<Cliente> getAll(Pageable pageable) {
        return CDAO.findAll(pageable);
    }

    @Override
    public void guardar(Cliente cliente) {
        CDAO.save(cliente);
        
    }

    @Override
    public List<Cliente> listar() {
        return CDAO.findAll();
    }

    @Override
    public Cliente guardarAPI(Cliente cliente) {
        return CDAO.save(cliente);
    }

}
