package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.DAO.ClienteDAO;
import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.ClienteDTO;

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

    @Override
    public List<Cliente> buscarcliente(String nombre) {
        if(CDAO.listaclientebusqueda(nombre).size()>0){
            List<Cliente> nombrecli=CDAO.listaclientebusqueda(nombre);
            return nombrecli;
        }else{
            return null;
        }
    }

    @Override
    public List<ClienteDTO> listclienteDTO() {
            List<Cliente> Clientes=CDAO.findAll();
            ClienteDTO clienteDTO;
            List<ClienteDTO> clientesDTO=new ArrayList();
                try {
                    for (Cliente DTOaux : Clientes) {
                    clienteDTO=new ClienteDTO();
                    System.out.println(DTOaux.getId());
                    clienteDTO.setId(DTOaux.getId());
                    clienteDTO.setNombre_apellido(DTOaux.getNombres()+" "+DTOaux.getApellidos());
                    clienteDTO.setNacimiento(DTOaux.getNacimiento());
                    clienteDTO.setTelefono(DTOaux.getTelefono());
                    System.out.println(clienteDTO.getId());
                    clientesDTO.add(clienteDTO);
                    }
                }
                catch (Exception e) {
                }
            return clientesDTO;
    }
}
