package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Citas;

@Repository
public interface CitasDAO extends JpaRepository<Citas,Long>{
    
}
