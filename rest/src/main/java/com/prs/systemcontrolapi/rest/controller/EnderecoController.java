package com.prs.systemcontrolapi.rest.controller;

import java.util.HashMap;
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
import com.prs.systemcontrolapi.rest.model.Endereco;
import com.prs.systemcontrolapi.rest.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Endereco>> get() {
		return ResponseEntity.ok(enderecoRepository.findAll());
	}
	
	@PostMapping
	public Endereco addEndereco(@Validated @RequestBody Endereco Endereco) {
		return enderecoRepository.save(Endereco);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getEnderecoById(@PathVariable(value = "id") Long idEndereco)
		throws ResourceNotFoundException{
		Endereco Endereco = enderecoRepository.findById(idEndereco)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idEndereco));
		return ResponseEntity.ok().body(Endereco);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Endereco> updateEndereco(@PathVariable(value = "id") Long idEndereco,
			@Validated @RequestBody Endereco EnderecoDetalhe) throws ResourceNotFoundException{
		Endereco Endereco = enderecoRepository.findById(idEndereco)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idEndereco));
		
		Endereco.setIdEndereco(EnderecoDetalhe.getIdEndereco());
		Endereco.setLogradouro(EnderecoDetalhe.getLogradouro());
		Endereco.setNumero(EnderecoDetalhe.getNumero());
		Endereco.setComplemento(EnderecoDetalhe.getComplemento());
		Endereco.setSetor_bairro(EnderecoDetalhe.getSetor_bairro());
		Endereco.setIdCidade(EnderecoDetalhe.getIdCidade());
		
		final Endereco EnderecoT = enderecoRepository.save(Endereco);
		return ResponseEntity.ok(EnderecoT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idEndereco)
		throws ResourceNotFoundException{
		Endereco Endereco = enderecoRepository.findById(idEndereco)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Endereco para esse :: " +idEndereco));
		enderecoRepository.delete(Endereco);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
