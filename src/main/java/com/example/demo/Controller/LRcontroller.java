package com.example.demo.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.SessionStatus;


@Controller
public class LRcontroller {

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping("/")
	public String inicio(@RequestParam(value = "error",required = false) String error, Model model, SessionStatus s) {
		if (error!=null) {
            model.addAttribute("error","usuario/contraseña incorrecta");
        }
		s.setComplete();
		// Usuarios user=(Usuarios) US.EncontrarUsuario(usuario);
		// model.addAttribute("usuario", user.getNombres());
		return "Ingreso/LOGIN_REGISTRO";
	}
}
