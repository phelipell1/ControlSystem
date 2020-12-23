package com.prs.systemcontrolapi.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prs.systemcontrolapi.rest.exception.ResourceNotFoundException;
import com.prs.systemcontrolapi.rest.model.Usuario;
import com.prs.systemcontrolapi.rest.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:4200/**", allowedHeaders = "*")
@RestController
@RequestMapping("user")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	@GetMapping()
	public ResponseEntity<Iterable<Usuario>> get() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@PostMapping()
	public Usuario addUsuario(@Validated @RequestBody Usuario Usuario) {
		return usuarioRepository.save(Usuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long idUsuario)
		throws ResourceNotFoundException{
		Usuario Usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idUsuario));
		return ResponseEntity.ok().body(Usuario);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long idUsuario,
			@Validated @RequestBody Usuario UsuarioDetalhe) throws ResourceNotFoundException{
		Usuario Usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idUsuario));
		
		Usuario.setIdUsuario(UsuarioDetalhe.getIdUsuario());
		Usuario.setCargo(UsuarioDetalhe.getCargo());
		Usuario.setDateCadastro(UsuarioDetalhe.getDateCadastro());
		Usuario.setIdPessoa(UsuarioDetalhe.getIdPessoa());
		Usuario.setNomeLogin(UsuarioDetalhe.getNomeLogin());
		Usuario.setPassword(UsuarioDetalhe.getPassword());
		Usuario.setStatus(UsuarioDetalhe.isStatus());
		
		final Usuario UsuarioT = usuarioRepository.save(Usuario);
		return ResponseEntity.ok(UsuarioT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idUsuario)
		throws ResourceNotFoundException{
		Usuario Usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Usuario para esse :: " +idUsuario));
		usuarioRepository.delete(Usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
	
}
