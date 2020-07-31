package com.prs.systemcontrolapi.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prs.systemcontrolapi.rest.exception.ResourceNotFoundException;
import com.prs.systemcontrolapi.rest.model.Usuario_model;
import com.prs.systemcontrolapi.rest.repository.UsuarioRepository;


@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/listaUsuarios")
	public List<Usuario_model> getAllUsuaios(){
		return usuarioRepository.findAll();
	}
	
	@PostMapping("/usuarios")
	public Usuario_model addUsuario_model(@Validated @RequestBody Usuario_model usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario_model> getUsuarioById(@PathVariable(value = "id") Long usuarioId)
			throws ResourceNotFoundException{
		Usuario_model usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum usuário correspondente ao id :: " + usuarioId));
		return ResponseEntity.ok().body(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario_model> updateUsuario(@PathVariable(value = "id") Long usuarioId,
			@Validated @RequestBody Usuario_model usuarioDetalhes) throws ResourceNotFoundException{
		Usuario_model usuarios = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar ::" +usuarioId));
		
		usuarios.setNome_completo(usuarioDetalhes.getNome_completo());
		usuarios.setEhAtivo(usuarioDetalhes.isEhAtivo());
		usuarios.setDataCadastro(usuarioDetalhes.getDataCadastro());
		usuarios.setEmail(usuarioDetalhes.getEmail());
		usuarios.setCargo(usuarioDetalhes.getCargo());
		usuarios.setPerfil(usuarioDetalhes.getPerfil());
		usuarios.setId_login(usuarioDetalhes.getId_login());
		final Usuario_model userModel = usuarioRepository.save(usuarios);
		return ResponseEntity.ok(userModel);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public Map<String, Boolean> deletarUsuario(@PathVariable(value = "id") Long usuarioId)
		throws ResourceNotFoundException{
		Usuario_model usuarios = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe usuário para esse id :: " +usuarioId));
		usuarioRepository.delete(usuarios);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
	
}
