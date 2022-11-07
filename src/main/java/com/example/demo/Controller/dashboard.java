package com.example.demo.Controller;

import java.security.Principal;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.Entity.Usuarios;
import com.example.demo.Service.UsuariosSer;

@Controller
public class dashboard {
	@Autowired
	private UsuariosSer US;
	@RequestMapping(value ="/index", method = RequestMethod.GET)
	public String inicio(Model model,String username,SessionStatus s) {
		model.addAttribute("afirmar", s.isComplete());
		return "Cliente/Cliente";
	}
}
