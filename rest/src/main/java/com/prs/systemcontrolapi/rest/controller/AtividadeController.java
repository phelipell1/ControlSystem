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
import com.prs.systemcontrolapi.rest.model.Atividade;
import com.prs.systemcontrolapi.rest.repository.AtividadeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/atividade")
public class AtividadeController {
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Atividade>> get() {
		return ResponseEntity.ok(atividadeRepository.findAll());
	}
	
	@PostMapping
	public Atividade addProcessos(@Validated @RequestBody Atividade atividade) {
		return atividadeRepository.save(atividade);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Atividade> getProcessoById(@PathVariable(value = "id") Long idAtividade)
		throws ResourceNotFoundException{
		Atividade vendas = atividadeRepository.findById(idAtividade)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idAtividade));
		return ResponseEntity.ok().body(vendas);
	}
	
	@GetMapping("/data/{dataInicio}")
	public ResponseEntity<Atividade> getByDataInicio(@PathVariable(value = "dataInicio") String dateInicio)
		throws ResourceNotFoundException{
		Atividade atividade = atividadeRepository.findByDataInicio(dateInicio)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+dateInicio));
		return ResponseEntity.ok().body(atividade);
	}
	
	@GetMapping("/nomeatividade/{nomeAtividade}")
	public ResponseEntity<Atividade> getByNomeAtividade(@PathVariable(value = "nomeAtividade") String nomeAtividade)
		throws ResourceNotFoundException{
		Atividade atividade = atividadeRepository.findByNomeAtividade(nomeAtividade)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar atividade :: "+nomeAtividade));
		return ResponseEntity.ok().body(atividade);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Atividade> updateAtividade(@PathVariable(value = "id") Long atividades,
			@Validated @RequestBody Atividade atividadeDetalhe) throws ResourceNotFoundException{
		Atividade atividade = atividadeRepository.findById(atividades)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+atividades));
		
		atividade.setIdAtividade(atividadeDetalhe.getIdAtividade());
		atividade.setNomeAtividade(atividadeDetalhe.getNomeAtividade());
		atividade.setDescricaoAtividade(atividadeDetalhe.getDescricaoAtividade());
		atividade.setDataInicio(atividadeDetalhe.getDataInicio());
		atividade.setDataTermino(atividadeDetalhe.getDataTermino());
		atividade.setStatus(atividadeDetalhe.isStatus());
		
		final Atividade atividadeT = atividadeRepository.save(atividade);
		return ResponseEntity.ok(atividadeT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idAtividade)
		throws ResourceNotFoundException{
		Atividade Atividade = atividadeRepository.findById(idAtividade)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Atividade para esse :: " +idAtividade));
		atividadeRepository.delete(Atividade);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}