package com.example.demo.Api_Rest;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.ClienteDTO;
import com.example.demo.Service.ClienteImp;

@RestController
@RequestMapping("/clienteapi")
public class RestClienteController {

	@Autowired
	private ClienteImp CDAO;

	String ruta="../POSTAMEDICA/src/main/resources/static/IMG/FOTOS/";
	@PostMapping("/uploadCliente")
	public ResponseEntity<Object> uploadFile(@RequestParam("File") MultipartFile file) throws IOException{
				File myFile=new File(ruta+file.getOriginalFilename());
				myFile.createNewFile();
				FileOutputStream fos=new FileOutputStream(myFile);
				fos.write(file.getBytes());
				fos.close();
		return new ResponseEntity<Object>("file successfuly",HttpStatus.OK);
	}

	// @GetMapping("/search/{nombre}")
	// public ResponseEntity<List<Cliente>> busqueda(@PathVariable("nombre") String nombre){
	// 	return new ResponseEntity<List<Cliente>>(CDAO.buscarcliente("%"+nombre+"%"),HttpStatus.OK);
    
	// }
	@GetMapping("/clienteDTO")
	public ResponseEntity<List<ClienteDTO>> busqueda(){
		return new ResponseEntity<List<ClienteDTO>>(CDAO.listclienteDTO(),HttpStatus.OK);
    
	}
}
