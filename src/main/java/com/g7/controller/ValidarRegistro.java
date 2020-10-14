package com.g7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g7.DAO.UsuarioDAO;
import com.g7.entidad.Usuario;

@RestController
@RequestMapping("/register")
public class ValidarRegistro {
	
	private UsuarioDAO dao = new UsuarioDAO();
	
	@PostMapping
	public boolean registro(@RequestBody Usuario usuario) {
		return dao.crear(usuario);
	}
}
