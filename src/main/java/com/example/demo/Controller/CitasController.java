package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/citas")
public class CitasController {
    @RequestMapping("/")
    public String form(){
        return "Citas/Citas";
    }
}
