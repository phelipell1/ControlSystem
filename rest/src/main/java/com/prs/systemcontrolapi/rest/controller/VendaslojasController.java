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
import com.prs.systemcontrolapi.rest.model.VendasLojas;
import com.prs.systemcontrolapi.rest.repository.VendasLojasRepository;

@RestController
@RequestMapping("/api")
public class VendaslojasController {
	
	@Autowired
	private VendasLojasRepository vendasRepository;
	
	@GetMapping("/vendaslojas")
	public List<VendasLojas> getAllVendasLoja(){
		return vendasRepository.findAll();
	}
	
	@PostMapping("/vendaslojas")
	public VendasLojas addProcessos(@Validated @RequestBody VendasLojas vendasloja) {
		return vendasRepository.save(vendasloja);
	}
	
	@GetMapping("/vendaslojas/{id}")
	public ResponseEntity<VendasLojas> getProcessoById(@PathVariable(value = "id") Long vendasLojaId)
		throws ResourceNotFoundException{
		VendasLojas vendas = vendasRepository.findById(vendasLojaId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+vendasLojaId));
		return ResponseEntity.ok().body(vendas);
	}
	
	@PutMapping("/vendaslojas/{id}")
	public ResponseEntity<VendasLojas> updateVendas(@PathVariable(value = "id") Long vendasLojaId,
			@Validated @RequestBody VendasLojas vendasDetalhes) throws ResourceNotFoundException{
		VendasLojas vendas = vendasRepository.findById(vendasLojaId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+vendasLojaId));
		
		vendas.setId_usuario(vendasDetalhes.getId_usuario());
		vendas.setId_loja(vendasDetalhes.getId_loja());
		vendas.setDataVenda(vendasDetalhes.getDataVenda());
		vendas.setListItensloja(vendasDetalhes.getListItensloja());
		vendas.setValorTotal(vendasDetalhes.getValorTotal());
		vendas.setTipoPagamento(vendasDetalhes.getTipoPagamento());
		vendas.setParcelado(vendasDetalhes.isParcelado());
		vendas.setTotalParcelas(vendasDetalhes.getTotalParcelas());
		
		final VendasLojas vendasT = vendasRepository.save(vendas);
		return ResponseEntity.ok(vendasT);
	}
	
	@DeleteMapping("/vendaslojas/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long vendasLojaId)
		throws ResourceNotFoundException{
		VendasLojas vendasLojas = vendasRepository.findById(vendasLojaId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe costureira para esse id :: " +vendasLojaId));
		vendasRepository.delete(vendasLojas);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
