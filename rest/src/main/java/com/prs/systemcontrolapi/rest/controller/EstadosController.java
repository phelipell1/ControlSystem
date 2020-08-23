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
import com.prs.systemcontrolapi.rest.model.Estados;
import com.prs.systemcontrolapi.rest.repository.EstadosRepository;

@RestController
@RequestMapping("/api")
public class EstadosController {
	
	@Autowired
	private EstadosRepository estadosRepository;
	
	@GetMapping("/estados")
	public List<Estados> getAllEstados(){
		return estadosRepository.findAll();
	}
	
	@PostMapping("/estados")
	public Estados addEstado(@Validated @RequestBody Estados estados) {
		return estadosRepository.save(estados);
	}
	
	@GetMapping("/estados/{id}")
	public ResponseEntity<Estados> getEstadosById(@PathVariable(value = "id") Long estadosId)
			throws ResourceNotFoundException{
		Estados estado = estadosRepository.findById(estadosId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi localizado o ID :: "+estadosId +" :: tente novamente."));
		return ResponseEntity.ok().body(estado);
	}
	
	@PutMapping("/estados/{id}")
	public ResponseEntity<Estados> updateEstados(@PathVariable(value = "id") Long estadosId,
			@Validated @RequestBody Estados estadosDetalhes) throws ResourceNotFoundException{
		Estados estado = estadosRepository.findById(estadosId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar ::" +estadosId));
		
		estado.setNome_estado(estadosDetalhes.getNome_estado());
		estado.setSigla_uf(estadosDetalhes.getSigla_uf());
		
		final Estados est = estadosRepository.save(estado);
		return ResponseEntity.ok(est);
	}
	
	@DeleteMapping("/estados/{id}")
	public Map<String, Boolean> deletarEstado(@PathVariable(value = "id") Long estadosId)
		throws ResourceNotFoundException{
		Estados estado = estadosRepository.findById(estadosId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe ficha Descritiva para esse id :: " +estadosId));
		estadosRepository.delete(estado);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
