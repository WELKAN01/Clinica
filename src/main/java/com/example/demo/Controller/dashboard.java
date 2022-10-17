package com.example.demo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Usuarios;
import com.example.demo.Service.UsuariosSer;

@Controller
public class dashboard {
	@Autowired
	private UsuariosSer US;
	@RequestMapping(value ="/index", method = RequestMethod.GET)
	public String inicio(Model model,String username,Principal principal) {
		Usuarios u=new Usuarios();
		u=US.EncontrarUsuario(principal.getName());
		model.addAttribute("respuesta", u.getNombres()+" "+u.getApellidos());
		return "Dashboard/Dashboard";
	}
}
