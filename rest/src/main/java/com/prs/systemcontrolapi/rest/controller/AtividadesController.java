package com.prs.systemcontrolapi.rest.controller;

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
import java.util.*;

import com.prs.systemcontrolapi.rest.repository.AtividadesRepository;
import com.prs.systemcontrolapi.rest.exception.ResourceNotFoundException;
import com.prs.systemcontrolapi.rest.model.Atividades;

@RestController
@RequestMapping("/api")
public class AtividadesController {
	
	@Autowired
	private AtividadesRepository atividadeRepository;
	
	@GetMapping("/atividades")
	public List<Atividades> getAllAtividades(){
		return atividadeRepository.findAll();
	}
	
	@PostMapping("/atividades")
	public Atividades addAtividades(@Validated @RequestBody Atividades atividades) {
		return atividadeRepository.save(atividades);
	}
	
	@GetMapping("/atividades/{id}")
	public ResponseEntity<Atividades> getAtividadesBy(@PathVariable(value = "id") Long atividadeId)
			throws ResourceNotFoundException{
		Atividades atividades = atividadeRepository.findById(atividadeId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe atividade para este ID ::" +atividadeId));
		return ResponseEntity.ok().body(atividades);
	}
	
	@PutMapping("atividades/{id}")
	public ResponseEntity<Atividades> updateAtividades(@PathVariable(value = "id") Long atividadeId,
			@Validated @RequestBody Atividades atividadeDetalhes)
			throws ResourceNotFoundException{
		Atividades atividades = atividadeRepository.findById(atividadeId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possivel prosseguir :: "+atividadeId));
		
		atividades.setTituloAtividade(atividadeDetalhes.getTituloAtividade());
		atividades.setDescricaoAtividade(atividadeDetalhes.getDescricaoAtividade());
		atividades.setDataCriacao(atividadeDetalhes.getDataCriacao());
		atividades.setFimAtividade(atividadeDetalhes.isFimAtividade());
		atividades.setId_usuario(atividadeDetalhes.getId_usuario());
		final Atividades atv = atividadeRepository.save(atividades);
		return ResponseEntity.ok(atv);
	}
	
	@DeleteMapping("/atividades/{id}")
	public Map<String, Boolean> deletaAtividade(@PathVariable(value = "id") long atividadeId)
			throws ResourceNotFoundException{
		Atividades atividade = atividadeRepository.findById(atividadeId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possivel deletar o ID ::" +atividadeId));
		atividadeRepository.delete(atividade);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
