package com.g7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g7.DAO.UsuarioDAO;
import com.g7.entidad.Usuario;

@RestController
@RequestMapping("/login")
@CrossOrigin (origins = "http://127.0.0.1:8887")
public class ValidarLogin {
	
	private UsuarioDAO dao = new UsuarioDAO();
	
	@PostMapping
	public boolean registro(@RequestBody Usuario usuario) {

		return dao.leer(usuario);
	}
	
	public boolean verificarLogin(Usuario usuario) {
		if(!this.verificarLongitudClave(usuario.getPassword())) {
			return false;
		}
		else if(!this.verificarLongitudNombre(usuario.getNombre())){
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean verificarLongitudNombre(String nombre) {
		return (nombre.length() > 1 && nombre.length() <= 6);
	}
	
	private boolean verificarLongitudClave(String clave) {
		return (clave.length() >= 3 && clave.length() < 6);
		
	}

}
