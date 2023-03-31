package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente,Long>{

    boolean trueu = true;

    @Query(
        value="SELECT * FROM cliente WHERE cli_nombres LIKE ?",
        nativeQuery = trueu
    )

    public List<Cliente> listaclientebusqueda(String clientekey);
}
