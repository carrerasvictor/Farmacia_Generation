package com.genFarma.genFarma.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.genFarma.genFarma.model.Categoria;
import com.genFarma.genFarma.repository.CategoriaRepository;

/**
 * @author Priscila
 * @version 1.0
 */
@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	// buscarTodosCategoria
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// buscarPorIdCategoria
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long idCategoria) {
		return repository.findById(idCategoria).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// buscarPorNome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> getByNome(@PathVariable String categoria) {
		return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(categoria));
	}

	// salvarCategoria
	@PostMapping
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	// atualizarCategoria
	@PutMapping
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}

	// deletarCategoria
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long idCategoria) {
		repository.deleteById(idCategoria);
	}
}