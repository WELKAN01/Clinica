package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente,Long>{
}
