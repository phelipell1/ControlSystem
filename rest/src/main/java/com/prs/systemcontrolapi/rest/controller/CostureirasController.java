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
import com.prs.systemcontrolapi.rest.model.Costureiras;
import com.prs.systemcontrolapi.rest.repository.CostureirasRepository;

@RestController
@RequestMapping("/api")
public class CostureirasController {
	
	@Autowired
	private CostureirasRepository costureirasRepository;
	
	@GetMapping("/costureiras")
	public List<Costureiras> getAllCostureiras(){
		return costureirasRepository.findAll();
	}
	
	@PostMapping("/costureiras")
	public Costureiras addCostureiras(@Validated @RequestBody Costureiras costureira) {
		return costureirasRepository.save(costureira);
	}
	
	@GetMapping("/costureira/{id}")
	public ResponseEntity<Costureiras> getCostureiraById(@PathVariable(value = "id") Long costureirasId)
		throws ResourceNotFoundException{
		Costureiras costureira = costureirasRepository.findById(costureirasId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+costureirasId));
		return ResponseEntity.ok().body(costureira);
	}
	
	@PutMapping("/costureiras/{id}")
	public ResponseEntity<Costureiras> updateCosuteiras(@PathVariable(value = "id") Long costureirasId,
			@Validated @RequestBody Costureiras costureiraDetalhes) throws ResourceNotFoundException{
		Costureiras costureira = costureirasRepository.findById(costureirasId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+costureirasId));
		
		costureira.setNome_completo(costureiraDetalhes.getNome_completo());
		costureira.setEndereco(costureiraDetalhes.getEndereco());
		costureira.setNumero(costureiraDetalhes.getNumero());
		costureira.setComplemento(costureiraDetalhes.getComplemento());
		costureira.setSetor_bairro(costureiraDetalhes.getSetor_bairro());
		costureira.setEhAtivo(costureiraDetalhes.isEhAtivo());
		costureira.setDataCadastro(costureiraDetalhes.getDataCadastro());
		costureira.setId_cidade(costureiraDetalhes.getId_cidade());
		
		final Costureiras cost = costureirasRepository.save(costureira);
		return ResponseEntity.ok(cost);
	}
	
	@DeleteMapping("/costureira/{id}")
	public Map<String, Boolean> deletarCostureira(@PathVariable(value = "id") Long costureirasId)
		throws ResourceNotFoundException{
		Costureiras costureira = costureirasRepository.findById(costureirasId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe costureira para esse id :: " +costureirasId));
		costureirasRepository.delete(costureira);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
	
}
