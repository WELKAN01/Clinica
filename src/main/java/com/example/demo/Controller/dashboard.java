package com.example.demo.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class dashboard {
	@Autowired
	@ResponseStatus(value =HttpStatus.OK)
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String inicio() {
		return "fragmento/frag";
	}
}
