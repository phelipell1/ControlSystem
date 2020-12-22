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
import com.prs.systemcontrolapi.rest.model.Costureira;
import com.prs.systemcontrolapi.rest.repository.CostureiraRepository;

@RestController
@RequestMapping("/costureira")
public class CostureiraController {
	
	@Autowired
	private CostureiraRepository costureiraRepository;
	

	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<Iterable<Costureira>> get() {
		return ResponseEntity.ok(costureiraRepository.findAll());
	}
	
	@PostMapping
	public Costureira addCostureira(@Validated @RequestBody Costureira Costureira) {
		return costureiraRepository.save(Costureira);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Costureira> getCostureiraById(@PathVariable(value = "id") Long idCostureira)
		throws ResourceNotFoundException{
		Costureira Costureira = costureiraRepository.findById(idCostureira)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idCostureira));
		return ResponseEntity.ok().body(Costureira);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Costureira> updateCostureira(@PathVariable(value = "id") Long idCostureira,
			@Validated @RequestBody Costureira CostureiraDetalhe) throws ResourceNotFoundException{
		Costureira Costureira = costureiraRepository.findById(idCostureira)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idCostureira));
		
		Costureira.setIdCostureira(CostureiraDetalhe.getIdCostureira());
		Costureira.setIdPessoa(CostureiraDetalhe.getIdPessoa());
		Costureira.setDateCadastro(CostureiraDetalhe.getDateCadastro());
		
		final Costureira CostureiraT = costureiraRepository.save(Costureira);
		return ResponseEntity.ok(CostureiraT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idCostureira)
		throws ResourceNotFoundException{
		Costureira Costureira = costureiraRepository.findById(idCostureira)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Costureira para esse :: " +idCostureira));
		costureiraRepository.delete(Costureira);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}