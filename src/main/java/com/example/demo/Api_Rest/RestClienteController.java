package com.example.demo.Api_Rest;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RestClienteController {

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
}
