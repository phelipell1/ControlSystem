package com.prs.systemcontrolapi.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prs.systemcontrolapi.rest.exception.ResourceNotFoundException;
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
	@PostMapping("/logins")
	public Logins_model addlogin(@Validated @RequestBody Logins_model login) {
		return loginRepository.save(login);
	}
	
	@DeleteMapping("/logins/{id}")
	public Map<String, Boolean> deletarLogin(@PathVariable(value = "id") Long loginId)
		throws ResourceNotFoundException{
		Logins_model login = loginRepository.findById(loginId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe login para esse id :: " +loginId));
		loginRepository.delete(login);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
