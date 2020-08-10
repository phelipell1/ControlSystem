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
import com.prs.systemcontrolapi.rest.model.Aviamentos;
import com.prs.systemcontrolapi.rest.repository.AviamentosRepository;

@RestController
@RequestMapping("/api")
public class AviamentosController {
	
	@Autowired
	private AviamentosRepository aviamentosRepository;
	
	@GetMapping("/aviamentos")
	public List<Aviamentos> getAllAviamentos(){
		return aviamentosRepository.findAll();
	}
	
	@PostMapping("/aviamentos")
	public Aviamentos addAviamentos(@Validated @RequestBody Aviamentos aviamentos) {
		return aviamentosRepository.save(aviamentos);
	}
	
	@GetMapping("/aviamentos/{id}")
	public ResponseEntity<Aviamentos> getAviamentos(@PathVariable(value = "id") Long aviamentos)
			throws ResourceNotFoundException{
		Aviamentos aviamento = aviamentosRepository.findById(aviamentos)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi localizado o ID :: "+aviamentos +" :: tente novamente."));
		return ResponseEntity.ok().body(aviamento);
	}
	
	@PutMapping("/aviamentos/{id}")
	public ResponseEntity<Aviamentos> updateAviamentos(@PathVariable(value = "id") Long aviamentos,
			@Validated @RequestBody Aviamentos aviamentosDetalhes) throws ResourceNotFoundException{
		Aviamentos aviamento = aviamentosRepository.findById(aviamentos)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar ::" +aviamentos));
		
		aviamento.setReferencia(aviamentosDetalhes.getReferencia());
		aviamento.setDescricao(aviamentosDetalhes.getDescricao());
		aviamento.setNomeResponsavel(aviamentosDetalhes.getNomeResponsavel());
		aviamento.setQtde(aviamentosDetalhes.getQtde());
		aviamento.setUM(aviamentosDetalhes.getUM());
		aviamento.setCustoUnitario(aviamentosDetalhes.getCustoUnitario());
		aviamento.setCustoProducao(aviamentosDetalhes.getCustoProducao());
		
		final Aviamentos aviamentoModel = aviamentosRepository.save(aviamento);
		return ResponseEntity.ok(aviamentoModel);
	}
	
	@DeleteMapping("/aviamentos/{id}")
	public Map<String, Boolean> deletarFichaDescritiva(@PathVariable(value = "id") Long aviamentos)
		throws ResourceNotFoundException{
		Aviamentos aviamento = aviamentosRepository.findById(aviamentos)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe ficha Descritiva para esse id :: " +aviamentos));
		aviamentosRepository.delete(aviamento);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
