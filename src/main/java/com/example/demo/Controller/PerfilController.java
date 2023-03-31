package com.example.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PerfilController {
    
    @RequestMapping(value="/perfil" , params="nombre")
        public String perfil(@RequestParam String nombre) {
            return "Perfil/perfil";
        }
}
