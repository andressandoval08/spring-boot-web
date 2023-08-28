package com.bolsaideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	//metodo que realiza una redireccion a una pagina http indicada
	@GetMapping("/")
	public String home() {
		return "redirect:/app/inicio"; 
		
		/* rutas propias del proyecto 
		 * return "forward:/app/inicio";
		 */
	}

}
