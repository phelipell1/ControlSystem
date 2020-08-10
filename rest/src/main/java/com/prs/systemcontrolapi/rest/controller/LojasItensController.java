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
import com.prs.systemcontrolapi.rest.model.LojasItens;
import com.prs.systemcontrolapi.rest.repository.LojasItensRepository;

@RestController
@RequestMapping("/api")
public class LojasItensController {
	
	@Autowired
	LojasItensRepository lojaitensRepository;
	
	@GetMapping("/lojaitens")
	public List<LojasItens> getAllLojaItens(){
		return lojaitensRepository.findAll();
	}
	
	@PostMapping("/lojaitens")
	public LojasItens addLojaItens(@Validated @RequestBody LojasItens lojaItens) {
		return lojaitensRepository.save(lojaItens);
	}
	
	@GetMapping("/lojaitens/{id}")
	public ResponseEntity<LojasItens> getAllLojaItensById(@PathVariable(value = "id") Long lojaItemId)
			throws ResourceNotFoundException{
		LojasItens lojaItens = lojaitensRepository.findById(lojaItemId)
				.orElseThrow(() -> new ResourceNotFoundException("Nada encontrado para esse ID :: "+lojaItemId));
		return ResponseEntity.ok().body(lojaItens);
	}
	
	@PutMapping("/lojaitens/{id}")
	public ResponseEntity<LojasItens> updateLojaItem(@PathVariable(value = "id") Long lojaItemId,
			@Validated @RequestBody LojasItens lojaItensDetalhes) throws ResourceNotFoundException{
		LojasItens itens = lojaitensRepository.findById(lojaItemId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar ::" +lojaItemId));
		
		itens.setId_loja(lojaItensDetalhes.getId_loja());
		itens.setId_usuario(lojaItensDetalhes.getId_usuario());
		itens.setDataEntrada(lojaItensDetalhes.getDataEntrada());
		itens.setQtdeEntrada(lojaItensDetalhes.getQtdeEntrada());
		final LojasItens lojaI = lojaitensRepository.save(itens);
		return ResponseEntity.ok(lojaI);
	}
	
	@DeleteMapping("/lojaitens/{id}")
	public Map<String, Boolean> deletarLojaItem(@PathVariable(value = "id") Long lojaItemId)
			throws ResourceNotFoundException{
		LojasItens lojaItem = lojaitensRepository.findById(lojaItemId)
				.orElseThrow(() -> new ResourceNotFoundException("ID Não localizado :: "+lojaItemId));
		lojaitensRepository.delete(lojaItem);
		Map<String, Boolean> response = new HashMap<>();
		response.put("O item"+lojaItem.getId_itensLoja()+"Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
	
}
