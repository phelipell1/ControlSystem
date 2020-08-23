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
import com.prs.systemcontrolapi.rest.model.Cidades;
import com.prs.systemcontrolapi.rest.repository.CidadesRepository;

@RestController
@RequestMapping("/api")
public class CidadesController {

	@Autowired
	private CidadesRepository cidadesRepository;
	
	@GetMapping("/cidades")
	public List<Cidades> getAllCidades(){
		return cidadesRepository.findAll();
	}
	
	@PostMapping("/cidades")
	public Cidades addCidades(@Validated @RequestBody Cidades cidades) {
		return cidadesRepository.save(cidades);
	}
	
	@GetMapping("/cidades/{id}")
	public ResponseEntity<Cidades> getCidadesById(@PathVariable(value = "id") Long cidadesId)
			throws ResourceNotFoundException{
		Cidades cidade = cidadesRepository.findById(cidadesId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi localizado o ID :: "+cidadesId +" :: tente novamente."));
		return ResponseEntity.ok().body(cidade);
	}
	
	@PutMapping("/cidades/{id}")
	public ResponseEntity<Cidades> updateCidades(@PathVariable(value = "id") Long cidadesId,
			@Validated @RequestBody Cidades cidadesDetalhes) throws ResourceNotFoundException{
		Cidades cidade = cidadesRepository.findById(cidadesId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar ::" +cidadesId));
		
		cidade.setCid_nome(cidadesDetalhes.getCid_nome());
		cidade.setId_estado(cidadesDetalhes.getId_estado());
		
		final Cidades city = cidadesRepository.save(cidade);
		return ResponseEntity.ok(city);
	}
	
	@DeleteMapping("/cidades/{id}")
	public Map<String, Boolean> deletarCidades(@PathVariable(value = "id") Long cidadeId)
		throws ResourceNotFoundException{
		Cidades cidade = cidadesRepository.findById(cidadeId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe ficha Descritiva para esse id :: " +cidadeId));
		cidadesRepository.delete(cidade);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
