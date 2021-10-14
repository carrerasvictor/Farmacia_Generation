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
import org.springframework.web.server.ResponseStatusException;

import com.genFarma.genFarma.model.Usuario;
import com.genFarma.genFarma.model.dtos.CredenciaisDTO;
import com.genFarma.genFarma.model.dtos.UsuarioLoginDTO;
import com.genFarma.genFarma.repository.UsuarioRepository;
import com.genFarma.genFarma.service.UsuarioService;

/**
 * @author Team Sinergia
 * @version 1.0
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	private @Autowired UsuarioRepository repository;
	private @Autowired UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long idUsuario) {
		return repository.findById(idUsuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoUsuario));
	}

	@PostMapping("/cadastro")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Usuario novoUsuario) {
		return service.cadastrarUsuario(novoUsuario).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Email existente, cadastre outro email!.");
				});

	}

	@PutMapping("/login")
	public ResponseEntity<CredenciaisDTO> logar(@Valid @RequestBody UsuarioLoginDTO usuarioParaAutenticar) {
		return service.pegarCredenciais(usuarioParaAutenticar);
	}

	@PutMapping
	public ResponseEntity<Usuario> put(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(novoUsuario));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long idUsuario) {
		repository.deleteById(idUsuario);
	}

}