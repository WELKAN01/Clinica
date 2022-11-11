package com.example.demo.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.DAO.ClienteDAO;
import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Usuarios;
import com.example.demo.Service.ClienteImp;
import com.example.demo.Service.UsuariosSer;

@Controller
@RequestMapping("/")
public class ClienteController {
    @Autowired
	private ClienteImp CDao;

	@RequestMapping("/Cliente")
	public String inicio(){
		return "Cliente/Cliente";
	}

	@RequestMapping("/save")
	public String uploadFile(@RequestParam(name="file",required = false) MultipartFile file,
	Cliente cliente,Model model,RedirectAttributes flash, String username) {
		if(file==null || file.isEmpty()){
			flash.addFlashAttribute("mesaje","Porfavor ingrese un archivo");
			return "Redirect:status";
		}
		String ruta="C://Users/Andy/Documents/springTRABAJO/POSTAMEDICA/src/main/resources/static/IMG/FOTOS";
		try {
			byte[] bytes=file.getBytes();
			Path rutaabsoluto=Paths.get(ruta+"/"+file.getOriginalFilename());
			Files.write(rutaabsoluto, bytes);
			cliente.setFoto(file.getOriginalFilename());
		} catch (Exception e) {
			// TODO: handle exception
		}
		CDao.guardar(cliente);
		flash.addFlashAttribute("correcto","Se subio todo");
		return "redirect:/Cliente/";
	}

}
