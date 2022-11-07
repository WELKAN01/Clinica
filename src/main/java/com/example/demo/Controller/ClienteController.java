package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.UsuariosSer;

@Controller
@RequestMapping("/")
public class ClienteController {
    @Autowired
	private UsuariosSer US;

	@RequestMapping("/Cliente")
	public String inicio(Model model,String username) {
	
		return "Cliente/Cliente";
	}
}
