package com.example.demo.Api_Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Sala;
import com.example.demo.Service.SalasImp;

@RestController
@RequestMapping("/Sala")
public class RestSalaController {
    
    @Autowired
    private SalasImp SI;


    @GetMapping("/lista")
    public ResponseEntity<List<Sala>> ListaSala(){
        return ResponseEntity.status(HttpStatus.OK).body(SI.ListSalas());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Sala> guardarsala(@RequestBody Sala sala){
        return ResponseEntity.status(HttpStatus.CREATED).body(SI.GuardarSala(sala));
    }
}
