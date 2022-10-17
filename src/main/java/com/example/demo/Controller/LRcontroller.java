package com.example.demo.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LRcontroller {

	@RequestMapping("/")
	public String inicio(@RequestParam(value = "error",required = false) String error, Model model) {
		if (error!=null) {
            model.addAttribute("error","usuario/contraseña incorrecta");
        }
		// Usuarios user=(Usuarios) US.EncontrarUsuario(usuario);
		// model.addAttribute("usuario", user.getNombres());
		return "Ingreso/LOGIN_REGISTRO";
	}
}
