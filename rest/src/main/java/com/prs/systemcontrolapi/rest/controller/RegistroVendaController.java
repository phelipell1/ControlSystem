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
import com.prs.systemcontrolapi.rest.model.RegistroVenda;
import com.prs.systemcontrolapi.rest.repository.RegistroVendaRepository;

@RestController
@RequestMapping("/registrovenda")
public class RegistroVendaController {
	
	@Autowired
	private RegistroVendaRepository regVendaRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<RegistroVenda>> get() {
		return ResponseEntity.ok(regVendaRepository.findAll());
	}
	
	@PostMapping
	public RegistroVenda addRegistroVenda(@Validated @RequestBody RegistroVenda RegistroVenda) {
		return regVendaRepository.save(RegistroVenda);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RegistroVenda> getRegistroVendaById(@PathVariable(value = "id") Long idRegistroVenda)
		throws ResourceNotFoundException{
		RegistroVenda RegistroVenda = regVendaRepository.findById(idRegistroVenda)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idRegistroVenda));
		return ResponseEntity.ok().body(RegistroVenda);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<RegistroVenda> updateRegistroVenda(@PathVariable(value = "id") Long idRegistroVenda,
			@Validated @RequestBody RegistroVenda RegistroVendaDetalhe) throws ResourceNotFoundException{
		RegistroVenda RegistroVenda = regVendaRepository.findById(idRegistroVenda)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idRegistroVenda));
		
		RegistroVenda.setIdRegistro(RegistroVendaDetalhe.getIdRegistro());
		RegistroVenda.setDataCompra(RegistroVenda.getDataCompra());
		RegistroVenda.setIdUsuario(RegistroVendaDetalhe.getIdUsuario());
		RegistroVenda.setListaProduto(RegistroVenda.getListaProduto());
		RegistroVenda.setTipoPagamento(RegistroVendaDetalhe.getTipoPagamento());
		RegistroVenda.setTotalCompra(RegistroVendaDetalhe.getTotalCompra());
		
		final RegistroVenda RegistroVendaT = regVendaRepository.save(RegistroVenda);
		return ResponseEntity.ok(RegistroVendaT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idRegistroVenda)
		throws ResourceNotFoundException{
		RegistroVenda RegistroVenda = regVendaRepository.findById(idRegistroVenda)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe RegistroVenda para esse :: " +idRegistroVenda));
		regVendaRepository.delete(RegistroVenda);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}

