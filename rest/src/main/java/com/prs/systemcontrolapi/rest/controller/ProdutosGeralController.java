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
import com.prs.systemcontrolapi.rest.model.ProdutosGeral;
import com.prs.systemcontrolapi.rest.repository.ProdutosGeralRespository;

@RestController
@RequestMapping("/api")
public class ProdutosGeralController {
	@Autowired
	private ProdutosGeralRespository pgRepository;
	
	@GetMapping("/listaprodutos")
	public List<ProdutosGeral> getAllProdutosGeral(){
		return pgRepository.findAll();
	}
	
	@PostMapping("/produtosgerais")
	public ProdutosGeral addProdutosGeral(@Validated @RequestBody ProdutosGeral produtosGerais) {
		return pgRepository.save(produtosGerais);
	}
	
	@GetMapping("/listaprodutos/{id}")
	public ResponseEntity<ProdutosGeral> getUsuarioById(@PathVariable(value = "id") Long pgId)
			throws ResourceNotFoundException{
		ProdutosGeral produtos = pgRepository.findById(pgId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum usuário correspondente ao id :: " + pgId));
		return ResponseEntity.ok().body(produtos);
	}
	
	@PutMapping("/produtosgerais/{id}")
	public ResponseEntity<ProdutosGeral> updateUsuario(@PathVariable(value = "id") Long pgId,
			@Validated @RequestBody ProdutosGeral pgDetalhes) throws ResourceNotFoundException{
		ProdutosGeral produtos = pgRepository.findById(pgId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar ::" +pgId));
		
		produtos.setDescricao(pgDetalhes.getDescricao());
		produtos.setCodigo_barras(pgDetalhes.getCodigo_barras());
		produtos.setCodigo_referencia(pgDetalhes.getCodigo_referencia());
		produtos.setTamanho(pgDetalhes.getTamanho());
		produtos.setQtde(pgDetalhes.getQtde());
		produtos.setQtdeMinima(pgDetalhes.getQtdeMinima());
		produtos.setDataCadastro(pgDetalhes.getDataCadastro());
		produtos.setValor(pgDetalhes.getValor());
		produtos.setId_usuario(pgDetalhes.getId_usuario());
		
		final ProdutosGeral userModel = pgRepository.save(produtos);
		return ResponseEntity.ok(userModel);
	}
	
	@DeleteMapping("/produtosgerais/{id}")
	public Map<String, Boolean> deletarUsuario(@PathVariable(value = "id") Long pgId)
		throws ResourceNotFoundException{
		ProdutosGeral produtos = pgRepository.findById(pgId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe produtos para esse id :: " +pgId));
		pgRepository.delete(produtos);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}

}
