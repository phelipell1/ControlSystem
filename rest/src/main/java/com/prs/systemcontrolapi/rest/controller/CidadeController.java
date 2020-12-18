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
import com.prs.systemcontrolapi.rest.model.Cidade;
import com.prs.systemcontrolapi.rest.repository.CidadeRepository;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Cidade>> get() {
		return ResponseEntity.ok(cidadeRepository.findAll());
	}
	
	@PostMapping
	public Cidade addCidade(@Validated @RequestBody Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> getCidadeById(@PathVariable(value = "id") Long idCidade)
		throws ResourceNotFoundException{
		Cidade cidade = cidadeRepository.findById(idCidade)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idCidade));
		return ResponseEntity.ok().body(cidade);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Cidade> updateCidade(@PathVariable(value = "id") Long idCidade,
			@Validated @RequestBody Cidade cidadeDetalhe) throws ResourceNotFoundException{
		Cidade cidade = cidadeRepository.findById(idCidade)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idCidade));
		
		cidade.setIdCidade(cidadeDetalhe.getIdCidade());
		cidade.setMunicipio(cidadeDetalhe.getMunicipio());
		cidade.setIdEstado(cidadeDetalhe.getIdEstado());
		
		final Cidade CidadeT = cidadeRepository.save(cidade);
		return ResponseEntity.ok(CidadeT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idCidade)
		throws ResourceNotFoundException{
		Cidade Cidade = cidadeRepository.findById(idCidade)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Cidade para esse :: " +idCidade));
		cidadeRepository.delete(Cidade);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}