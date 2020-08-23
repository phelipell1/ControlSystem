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
import com.prs.systemcontrolapi.rest.model.Processo;
import com.prs.systemcontrolapi.rest.repository.ProcessosRepository;

@RestController
@RequestMapping("/api")
public class ProcessosController {

	@Autowired
	private ProcessosRepository processoRepository;
	
	@GetMapping("/processos")
	public List<Processo> getAllProcessos(){
		return processoRepository.findAll();
	}
	
	@PostMapping("/processos")
	public Processo addProcessos(@Validated @RequestBody Processo processo) {
		return processoRepository.save(processo);
	}
	
	@GetMapping("/processos/{id}")
	public ResponseEntity<Processo> getProcessoById(@PathVariable(value = "id") Long processosId)
		throws ResourceNotFoundException{
		Processo processo = processoRepository.findById(processosId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+processosId));
		return ResponseEntity.ok().body(processo);
	}
	
	@PutMapping("/processos/{id}")
	public ResponseEntity<Processo> updateProcesso(@PathVariable(value = "id") Long processosId,
			@Validated @RequestBody Processo processosDetalhes) throws ResourceNotFoundException{
		Processo processo = processoRepository.findById(processosId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+processosId));
		
		processo.setReferencia(processosDetalhes.getReferencia());
		processo.setDescricao(processosDetalhes.getDescricao());
		processo.setQtde(processosDetalhes.getQtde());
		processo.setUM(processosDetalhes.getUM());
		processo.setCusto_unitario(processosDetalhes.getCusto_unitario());
		processo.setCusto_producao(processosDetalhes.getCusto_producao());
		processo.setValor_pago(processosDetalhes.getValor_pago());
		
		final Processo process = processoRepository.save(processo);
		return ResponseEntity.ok(process);
	}
	
	@DeleteMapping("/processos/{id}")
	public Map<String, Boolean> deletarCostureira(@PathVariable(value = "id") Long processosId)
		throws ResourceNotFoundException{
		Processo processo = processoRepository.findById(processosId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe costureira para esse id :: " +processosId));
		processoRepository.delete(processo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
