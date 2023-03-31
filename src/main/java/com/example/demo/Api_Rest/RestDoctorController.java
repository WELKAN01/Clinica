package com.example.demo.Api_Rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Entity.Doctor;
import com.example.demo.Service.DoctorImp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/doctor")
public class RestDoctorController {
    
    @Autowired
    private DoctorImp DI;

    @GetMapping("/lista")
    public ResponseEntity<List<Doctor>> Getdoctor(){
        return ResponseEntity.status(HttpStatus.OK).body(DI.getDoctor());
    }
    // @PostMapping("/guardardoctor")
    // public ResponseEntity<String> postDoctor(@RequestBody Doctor doctor){
    //     return new ResponseEntity<String>(DI.guardaDoctor(doctor),HttpStatus.CREATED); 
    // }

    
    @PostMapping(value="/guardardoctor")
    public ResponseEntity<String> postDoctor(@RequestParam(value = "file") MultipartFile file,Doctor doctor) throws IOException{
        String ruta="../POSTAMEDICA/src/main/resources/static/IMG/FOTOS/Doctores/";
        File myFile=new File(ruta+file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream FO=new FileOutputStream(myFile);
        FO.write(file.getBytes());
        FO.close();
        doctor.setFoto(file.getOriginalFilename());
        return new ResponseEntity<String>(DI.guardaDoctor(doctor),HttpStatus.CREATED); 
    }
}


