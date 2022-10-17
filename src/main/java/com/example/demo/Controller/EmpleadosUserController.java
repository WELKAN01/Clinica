package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Usuarios;
import com.example.demo.Service.UsuarioImp;

@Controller
@RequestMapping("/")
public class EmpleadosUserController {
    @Autowired
    private UsuarioImp UI;

    @RequestMapping("/usuarios")
    public String usuariosList(Model model) {
        Usuarios user=new Usuarios();
        model.addAttribute("ListaUsuarios", UI.cargarUsuarios());
        return "Usuarios/usuarios";
    }
}
