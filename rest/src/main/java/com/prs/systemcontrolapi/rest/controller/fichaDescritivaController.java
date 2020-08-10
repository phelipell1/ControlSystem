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
import com.prs.systemcontrolapi.rest.model.FichaDescritiva;
import com.prs.systemcontrolapi.rest.repository.fichaDescritivaRepository;

@RestController
@RequestMapping("/api")
public class fichaDescritivaController {
	
	@Autowired
	private fichaDescritivaRepository fichaDescRepository;
	
	@GetMapping("/fichadescritiva")
	public List<FichaDescritiva> getAllFichaDescritivas(){
		return fichaDescRepository.findAll();
	}
	
	@PostMapping("/fichadescritiva")
	public FichaDescritiva addFichaDescritiva(@Validated @RequestBody FichaDescritiva fichaDesc) {
		return fichaDescRepository.save(fichaDesc);
	}
	
	@GetMapping("/fichadescritiva/{id}")
	public ResponseEntity<FichaDescritiva> getFichaDescritivaById(@PathVariable(value = "id") Long fichaDesc)
			throws ResourceNotFoundException{
		FichaDescritiva fichaDescritiva = fichaDescRepository.findById(fichaDesc)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi localizado o ID :: "+fichaDesc +" :: tente novamente."));
		return ResponseEntity.ok().body(fichaDescritiva);
	}
	
	@PutMapping("/fichadescritiva/{id}")
	public ResponseEntity<FichaDescritiva> updateFichaDescritiva(@PathVariable(value = "id") Long fichaDesc,
			@Validated @RequestBody FichaDescritiva fichaDescDetalhes) throws ResourceNotFoundException{
		FichaDescritiva fichaDescritiva = fichaDescRepository.findById(fichaDesc)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar ::" +fichaDesc));
		
		fichaDescritiva.setReferencia(fichaDescDetalhes.getReferencia());
		fichaDescritiva.setDescricao(fichaDescDetalhes.getDescricao());
		fichaDescritiva.setNomeResponsavel(fichaDescDetalhes.getNomeResponsavel());
		fichaDescritiva.setQtde(fichaDescDetalhes.getQtde());
		fichaDescritiva.setUM(fichaDescDetalhes.getUM());
		fichaDescritiva.setCustoUnitario(fichaDescDetalhes.getCustoUnitario());
		fichaDescritiva.setCustoProducao(fichaDescDetalhes.getCustoProducao());
		
		final FichaDescritiva fichaDescModel = fichaDescRepository.save(fichaDescritiva);
		return ResponseEntity.ok(fichaDescModel);
	}
	
	@DeleteMapping("/fichadescritiva/{id}")
	public Map<String, Boolean> deletarFichaDescritiva(@PathVariable(value = "id") Long fichaDesc)
		throws ResourceNotFoundException{
		FichaDescritiva fichaDescritiva = fichaDescRepository.findById(fichaDesc)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe ficha Descritiva para esse id :: " +fichaDesc));
		fichaDescRepository.delete(fichaDescritiva);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
