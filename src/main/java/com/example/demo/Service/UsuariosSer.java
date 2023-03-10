package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAO.UsuariosDAO;
import com.example.demo.Entity.Rol;
import com.example.demo.Entity.Usuarios;


@Service("UsuariosSer")
public class UsuariosSer implements UserDetailsService, UsuarioImp {
	@Autowired
	private UsuariosDAO UDAO;
	//Cargar los usuarios si existen o no
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios u=UDAO.findByUsername(username);
		if (u==null) {
			throw new UsernameNotFoundException("no se encuentra ninguno usuario o ingreso mal");
		}
	//va listando los roles existentes	 
		List<GrantedAuthority> listaroles = new ArrayList<>();
        
        for (Rol item : u.getRol()) {
        listaroles.add(new SimpleGrantedAuthority(item.getAuthority()));
		}
	//al final de la funcion Userdetails obtiene USER(name,password,rol)
		// return new User(u.getUsername(), u.getPassword(), listaroles);
		return new UsuarioDetalle(u);
	}

	//encontrar el dato del usuario que buscamos para hallar sus datos
	@Override
	public Usuarios EncontrarUsuario(String usuario) {
		return UDAO.findByUsername(usuario);
	}

	//GUARDAR USUARIOS NO REPETIDOS

	

	//ENCONTRAR TODOS LOS USUARIOS EXISTENTES
	@Override
	public List<Usuarios> cargarUsuarios() {
		return (List<Usuarios>) UDAO.findAll();
	}

	@Override
	public Usuarios buscarUsuarioID(Long id) {
		return UDAO.findById(id).orElse(null);
	}

	// @Override
	// public Usuarios GuardarUsuario(Usuarios usuario) {
	// 	int entero=Math.toIntExact(usuario.getId());
	// 	usuario.setRol(Arrays.asList(new Rol(entero,"USER")));
	// 	return UDAO.save(usuario);
	// }

	
}
