package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Entity.Rol;
import com.example.demo.Entity.Usuarios;

public class UsuarioDetalle implements UserDetails {

    private Usuarios user;
    

    public UsuarioDetalle(Usuarios user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> listaroles = new ArrayList<>();
        
        	for (Rol item : user.getRol()) {
            listaroles.add(new SimpleGrantedAuthority(item.getAuthority()));
        	}
        return listaroles;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    public String getNombres(){
        return user.getNombres();
    }
    
    public String getApellidos() {
        return user.getApellidos();
    }
    public String getCorreo() {
        return user.getCorreo();
    }
}
