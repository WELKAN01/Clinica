package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.Entity.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente,Long>{
}
