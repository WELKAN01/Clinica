package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Sala")
public class SalaController {
    @RequestMapping("/")
    public String sala(){
        return "Salas/sala";
    }
}
