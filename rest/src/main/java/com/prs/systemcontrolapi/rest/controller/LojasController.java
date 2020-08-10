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
import com.prs.systemcontrolapi.rest.model.Lojas;
import com.prs.systemcontrolapi.rest.repository.LojasRepostirory;

@RestController
@RequestMapping("/api")
public class LojasController {
	
	@Autowired
	private LojasRepostirory lojasRepository;
	
	@GetMapping("/lojas")
	public List<Lojas> getAllLojas(){
		return lojasRepository.findAll();
	}
	
	@PostMapping("/lojas")
	public Lojas addLojas(@Validated @RequestBody Lojas lojas) {
		return lojasRepository.save(lojas);
	}
	
	@GetMapping("/lojas/{id}")
	public ResponseEntity<Lojas> getLojasById(@PathVariable(value = "id") Long lojasId)
			throws ResourceNotFoundException{
		Lojas lojas = lojasRepository.findById(lojasId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma loja encontrada para o ID correspondente ::" +lojasId));
		return ResponseEntity.ok().body(lojas);
	}
	
	@PutMapping("/lojas/{id}")
	public ResponseEntity<Lojas> updateLoja(@PathVariable(value = "id") Long lojasId,
			@Validated @RequestBody Lojas lojasDetalhes) throws ResourceNotFoundException{
		Lojas lojas = lojasRepository.findById(lojasId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possivel atualizar ::"+lojasId));
		
		lojas.setNome_loja(lojasDetalhes.getNome_loja());
		lojas.setEndereco(lojasDetalhes.getEndereco());
		lojas.setNumero(lojasDetalhes.getNumero());
		lojas.setSetorBairro(lojasDetalhes.getSetorBairro());
		lojas.setComplementos(lojasDetalhes.getComplementos());
		lojas.setEhAtivo(lojasDetalhes.isEhAtivo());
		final Lojas loja = lojasRepository.save(lojas);
		return ResponseEntity.ok(loja);
	}
	
	@DeleteMapping("/lojas/{id}")
	public Map<String, Boolean> deletarLoja(@PathVariable(value = "id") Long lojasId)
	throws ResourceNotFoundException{
		Lojas lojas = lojasRepository.findById(lojasId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe loja para esse ID :: "+lojasId));
		lojasRepository.delete(lojas);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}