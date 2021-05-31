package com.isitsafe.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isitsafe.controllers.interfaces.BaseController;
import com.isitsafe.models.Usuario;
import com.isitsafe.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController implements BaseController<Usuario>{
	
	@Autowired
	private UsuarioService service;

	@Override
	@GetMapping(path = "/index")
	public ResponseEntity<List<Usuario>> index() {
		return ResponseEntity.ok(this.service.readAll());
	}

	@Override
	@GetMapping(path = "/show/{id}")
	public ResponseEntity<Optional<Usuario>> show(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(this.service.read(id));
	}

	@Override
	@PostMapping(path = "/create")
	public ResponseEntity<Usuario> store(@RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(this.service.create(usuario));
	}

	@Override
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<Usuario> update(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(this.service.update(id, usuario));
	}

	@Override
	@DeleteMapping(path = "/destroy/{id}")
	public ResponseEntity<String> destroy(@PathVariable(name = "id") Long id) {
		this.service.delete(id);
		return ResponseEntity.ok("Usuario Deletado com Sucesso!");
	}
	
}