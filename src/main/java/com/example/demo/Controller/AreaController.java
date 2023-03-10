package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Areas")
public class AreaController {
    @RequestMapping("/")
    public String inicio() {
        return "Areas/Areas";
    }
    
}
