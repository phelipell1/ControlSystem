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
import com.prs.systemcontrolapi.rest.model.RegistroContas;
import com.prs.systemcontrolapi.rest.repository.RegistroContasRepository;

@RestController
@RequestMapping("/api")
public class RegistroContasController {
	
	@Autowired
	private RegistroContasRepository regRepository;
	
	@GetMapping("/registrocontas")
	public List<RegistroContas> getAllRegistroContas(){
		return regRepository.findAll();
	}
	
	@PostMapping("/registrocontas")
	public RegistroContas regContas(@Validated @RequestBody RegistroContas regContas) {
		return regRepository.save(regContas);
	}
	
	@GetMapping("/registrocontas/{id}")
	public ResponseEntity<RegistroContas> getRegistroContasById(@PathVariable(value = "id") Long regContasId)
	throws ResourceNotFoundException{
		RegistroContas regContas = regRepository.findById(regContasId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possivel localizar :: "+regContasId));
		return ResponseEntity.ok().body(regContas);
	}
	
	@PutMapping("/registrocontas/{id}")
	public ResponseEntity<RegistroContas> updateRegContas(@PathVariable(value = "id") Long regContasId,
			@Validated @RequestBody RegistroContas regContasDetalhes) throws ResourceNotFoundException{
		RegistroContas registro = regRepository.findById(regContasId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possivel localizar o ID "+regContasId));
		
		registro.setDescricaoConta(regContasDetalhes.getDescricaoConta());
		registro.setValorTotal(regContasDetalhes.getValorTotal());
		registro.setParcelado(regContasDetalhes.isParcelado());
		registro.setValorParcela(regContasDetalhes.getValorParcela());
		registro.setDataVencimento(regContasDetalhes.getDataVencimento());
		registro.setQuitado(regContasDetalhes.isParcelado());
		registro.setId_loja(regContasDetalhes.getId_loja());
		final RegistroContas registroM = regRepository.save(registro);
		return ResponseEntity.ok(registroM);
	}
	
	@DeleteMapping("/registrocontas/{id}")
	public Map<String, Boolean> deleteRegistro (@PathVariable(value = "id") Long regContasId)
			throws ResourceNotFoundException{
		RegistroContas reg = regRepository.findById(regContasId)
				.orElseThrow(() -> new ResourceNotFoundException("ID não localizado :: "+regContasId));
		regRepository.delete(reg);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}