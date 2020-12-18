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
import com.prs.systemcontrolapi.rest.model.Pessoa;
import com.prs.systemcontrolapi.rest.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Pessoa>> get() {
		return ResponseEntity.ok(pessoaRepository.findAll());
	}
	
	@PostMapping
	public Pessoa addPessoa(@Validated @RequestBody Pessoa Pessoa) {
		return pessoaRepository.save(Pessoa);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getPessoaById(@PathVariable(value = "id") Long idPessoa)
		throws ResourceNotFoundException{
		Pessoa Pessoa = pessoaRepository.findById(idPessoa)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idPessoa));
		return ResponseEntity.ok().body(Pessoa);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable(value = "id") Long idPessoa,
			@Validated @RequestBody Pessoa PessoaDetalhe) throws ResourceNotFoundException{
		Pessoa Pessoa = pessoaRepository.findById(idPessoa)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idPessoa));
		
		Pessoa.setIdPessoa(PessoaDetalhe.getIdPessoa());
		Pessoa.setCPF(PessoaDetalhe.getCPF());
		Pessoa.setDataNascimento(PessoaDetalhe.getDataNascimento());
		Pessoa.setEmail(PessoaDetalhe.getEmail());
		Pessoa.setEstCivil(PessoaDetalhe.getEstCivil());
		Pessoa.setSexo(PessoaDetalhe.getSexo());
		Pessoa.setIdEndereco(PessoaDetalhe.getIdEndereco());
		Pessoa.setNomeCompleto(PessoaDetalhe.getNomeCompleto());
		Pessoa.setNumCelular(PessoaDetalhe.getNumCelular());
		Pessoa.setNumFixo(PessoaDetalhe.getNumFixo());
		
		final Pessoa PessoaT = pessoaRepository.save(Pessoa);
		return ResponseEntity.ok(PessoaT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idPessoa)
		throws ResourceNotFoundException{
		Pessoa Pessoa = pessoaRepository.findById(idPessoa)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Pessoa para esse :: " +idPessoa));
		pessoaRepository.delete(Pessoa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}