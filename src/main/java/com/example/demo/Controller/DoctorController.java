package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Doctor")
public class DoctorController {
    @RequestMapping("/")
    public String inicio() {
        return "Doctor/Doctor";
    }
}
