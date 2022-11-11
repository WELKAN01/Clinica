package com.example.demo.Rest;

import java.net.http.HttpHeaders;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Usuarios;
import com.example.demo.Service.UsuarioImp;

@RestController
@RequestMapping("/")
public class RestEmpleadosUser {
    @Autowired
    private UsuarioImp UI;
    @GetMapping("/usuariolistx")
    public ResponseEntity<List<Usuarios>> ok(){
        return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .body(UI.cargarUsuarios());
    } 

    @RequestMapping("/usuariolist")
    public List<Usuarios> VusuariosList(Model model) {
        return UI.cargarUsuarios();
    }
    @RequestMapping(value = "/usuariolist/{id}",method = RequestMethod.GET)
    public Usuarios SearchList(@PathVariable Long id) {
        return UI.buscarUsuarioID(id); 
    }
}
