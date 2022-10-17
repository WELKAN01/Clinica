package com.example.demo.Service;
import java.util.List;

import com.example.demo.Entity.Usuarios;

public interface UsuarioImp {
    public Usuarios EncontrarUsuario(String usuario);
    public void GuardarUsuario(Usuarios usuarios);
    public List<Usuarios> cargarUsuarios();
}
