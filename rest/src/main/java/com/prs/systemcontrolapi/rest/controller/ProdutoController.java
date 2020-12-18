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
import com.prs.systemcontrolapi.rest.model.Produto;
import com.prs.systemcontrolapi.rest.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Produto>> get() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@PostMapping
	public Produto addProduto(@Validated @RequestBody Produto Produto) {
		return produtoRepository.save(Produto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable(value = "id") Long idProduto)
		throws ResourceNotFoundException{
		Produto Produto = produtoRepository.findById(idProduto)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idProduto));
		return ResponseEntity.ok().body(Produto);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable(value = "id") Long idProduto,
			@Validated @RequestBody Produto ProdutoDetalhe) throws ResourceNotFoundException{
		Produto Produto = produtoRepository.findById(idProduto)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idProduto));
		
		Produto.setIdProduto(ProdutoDetalhe.getIdProduto());
		Produto.setCodProduto(ProdutoDetalhe.getCodProduto());
		Produto.setDateCadastro(ProdutoDetalhe.getDateCadastro());
		Produto.setDescricaoProduto(ProdutoDetalhe.getDescricaoProduto());
		Produto.setIdLoja(ProdutoDetalhe.getIdLoja());
		Produto.setIdUsuario(ProdutoDetalhe.getIdUsuario());
		Produto.setNomeProduto(ProdutoDetalhe.getNomeProduto());
		Produto.setQuantidade(ProdutoDetalhe.getQuantidade());
		
		final Produto ProdutoT = produtoRepository.save(Produto);
		return ResponseEntity.ok(ProdutoT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idProduto)
		throws ResourceNotFoundException{
		Produto Produto = produtoRepository.findById(idProduto)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Produto para esse :: " +idProduto));
		produtoRepository.delete(Produto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}