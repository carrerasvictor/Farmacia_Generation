package com.genFarma.genFarma.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.genFarma.genFarma.model.Produto;
import com.genFarma.genFarma.repository.ProdutoRepository;

/**
 * @author Leonardo
 * @version 1.0
 */
@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	// buscarTodosProdutos
	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// buscarPorIdProduto
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long idProduto) {
		return repository.findById(idProduto).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// buscarPorNome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String produto) {
		return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(produto));
	}

	// buscarPorMenorPreco
	@GetMapping("/preco/{preco}")
	public ResponseEntity<List<Produto>> getByMenorPreco(@PathVariable Double preco) {
		return ResponseEntity.ok(repository.findByPrecoLessThan(preco));
	}

	// buscarPorMaiorPreco
	@GetMapping("/preco/{preco}")
	public ResponseEntity<List<Produto>> getByMaiorPreco(@PathVariable Double preco) {
		return ResponseEntity.ok(repository.findByPrecoGreaterThan(preco));
	}

	// buscarPorSubcategoria
	@GetMapping("/subcategoria/{subcategoria}")
	public ResponseEntity<List<Produto>> getBySubcategoria(@PathVariable String subcategoria) {
		return ResponseEntity.ok(repository.findBySubcategoriaContainingIgnoreCase(subcategoria));
	}

	// salvarProduto
	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto novoProduto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoProduto));
	}

	// atualizarProduto
	@PutMapping
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto novoProduto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(novoProduto));
	}

	// deletarProduto
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long idProduto) {
		repository.deleteById(idProduto);
	}
}