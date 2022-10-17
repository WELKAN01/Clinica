package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Usuarios;


public interface UsuariosDAO extends CrudRepository<Usuarios, Long> {
	public Usuarios findByUsername(String username);
}
