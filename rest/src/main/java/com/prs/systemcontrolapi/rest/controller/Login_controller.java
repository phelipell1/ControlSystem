package com.prs.systemcontrolapi.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prs.systemcontrolapi.rest.model.Logins_model;
import com.prs.systemcontrolapi.rest.repository.LoginRepository;

@RestController
@RequestMapping("/api")
public class Login_controller {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping("/listaLogins")
	public List<Logins_model> getLogins_models(){
		return loginRepository.findAll();
	}
	
}
