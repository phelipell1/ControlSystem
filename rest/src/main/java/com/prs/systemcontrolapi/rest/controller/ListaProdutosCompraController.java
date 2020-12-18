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
import com.prs.systemcontrolapi.rest.model.ListaProdutosCompra;
import com.prs.systemcontrolapi.rest.model.ListaProdutosCompra;
import com.prs.systemcontrolapi.rest.repository.ListaProdutosCompraRepository;

@RestController
@RequestMapping("/listaproduto")
public class ListaProdutosCompraController {
	
	@Autowired
	private ListaProdutosCompraRepository listaProdutoRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<ListaProdutosCompra>> get() {
		return ResponseEntity.ok(listaProdutoRepository.findAll());
	}
	
	@PostMapping
	public ListaProdutosCompra addListaProdutosCompra(@Validated @RequestBody ListaProdutosCompra ListaProdutosCompra) {
		return listaProdutoRepository.save(ListaProdutosCompra);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ListaProdutosCompra> getListaProdutosCompraById(@PathVariable(value = "id") Long idListaProdutosCompra)
		throws ResourceNotFoundException{
		ListaProdutosCompra ListaProdutosCompra = listaProdutoRepository.findById(idListaProdutosCompra)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idListaProdutosCompra));
		return ResponseEntity.ok().body(ListaProdutosCompra);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ListaProdutosCompra> updateListaProdutosCompra(@PathVariable(value = "id") Long idListaProdutosCompra,
			@Validated @RequestBody ListaProdutosCompra ListaProdutosCompraDetalhe) throws ResourceNotFoundException{
		ListaProdutosCompra ListaProdutosCompra = listaProdutoRepository.findById(idListaProdutosCompra)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idListaProdutosCompra));
		
		ListaProdutosCompra.setIdRegistro(ListaProdutosCompraDetalhe.getIdRegistro());
		ListaProdutosCompra.setListaProduta(ListaProdutosCompraDetalhe.getListaProduta());
		
		final ListaProdutosCompra ListaProdutosCompraT = listaProdutoRepository.save(ListaProdutosCompra);
		return ResponseEntity.ok(ListaProdutosCompraT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idListaProdutosCompra)
		throws ResourceNotFoundException{
		ListaProdutosCompra ListaProdutosCompra = listaProdutoRepository.findById(idListaProdutosCompra)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe ListaProdutosCompra para esse :: " +idListaProdutosCompra));
		listaProdutoRepository.delete(ListaProdutosCompra);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}