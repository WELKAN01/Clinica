package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Doctor;

public interface DoctorDAO extends JpaRepository<Doctor,Long>{
    
}
