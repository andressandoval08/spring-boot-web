package com.bolsaideas.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.inicio.titulo}")
	private String textoIndex;

	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/inicio","/", "/home"})
	public String inicio(Map<String, Object> map){
		map.put("titulo", textoIndex);
		
		return "inicio";
	}
	
	
	@RequestMapping ("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Andres");
		usuario.setApellido("Pachon");
		usuario.setEmail("andres@gmail.com");
		
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Map<String, Object> map) {
		map.put("titulo", textoListar);
		// map.put("usuarios", usuarios); // nombrar igual que en las variables en singular o plural
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("andres", "pachon","andres@gmail.com"));
		usuarios.add(new Usuario("camilo", "doe","camilo@gmail.com"));
		usuarios.add(new Usuario("ricardo", "pachon","ricardo@gmail.com"));
		
		return usuarios;
	}
	
	
}
