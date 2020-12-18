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
import com.prs.systemcontrolapi.rest.model.Loja;
import com.prs.systemcontrolapi.rest.repository.LojaRepository;
import com.prs.systemcontrolapi.rest.repository.LojaRepository;

@RestController
@RequestMapping("/loja")
public class LojaController {
	
	@Autowired
	private LojaRepository lojaRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Loja>> get() {
		return ResponseEntity.ok(lojaRepository.findAll());
	}
	
	@PostMapping
	public Loja addLoja(@Validated @RequestBody Loja Loja) {
		return lojaRepository.save(Loja);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Loja> getLojaById(@PathVariable(value = "id") Long idLoja)
		throws ResourceNotFoundException{
		Loja Loja = lojaRepository.findById(idLoja)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idLoja));
		return ResponseEntity.ok().body(Loja);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Loja> updateLoja(@PathVariable(value = "id") Long idLoja,
			@Validated @RequestBody Loja LojaDetalhe) throws ResourceNotFoundException{
		Loja Loja = lojaRepository.findById(idLoja)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idLoja));
		
		Loja.setIdLoja(LojaDetalhe.getIdLoja());
		Loja.setNomeFantasia(LojaDetalhe.getNomeFantasia());
		Loja.setCnpj(LojaDetalhe.getCnpj());
		Loja.setIdEndereco(LojaDetalhe.getIdEndereco());
		Loja.setInscEstadual(LojaDetalhe.getInscEstadual());
		Loja.setStatus(LojaDetalhe.isStatus());
		
		final Loja LojaT = lojaRepository.save(Loja);
		return ResponseEntity.ok(LojaT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idLoja)
		throws ResourceNotFoundException{
		Loja Loja = lojaRepository.findById(idLoja)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Loja para esse :: " +idLoja));
		lojaRepository.delete(Loja);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}