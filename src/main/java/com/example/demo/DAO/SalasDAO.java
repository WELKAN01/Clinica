package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Sala;

public interface SalasDAO extends JpaRepository<Sala,Long> {
    
}
