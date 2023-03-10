package com.example.demo.Service;
import java.util.List;

import com.example.demo.Entity.Usuarios;

public interface UsuarioImp {
    public Usuarios EncontrarUsuario(String usuario);
    public Usuarios buscarUsuarioID(Long id);
    // public Usuarios GuardarUsuario(Usuarios usuario);
    public List<Usuarios> cargarUsuarios();
}
