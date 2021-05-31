package com.isitsafe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isitsafe.repositories.UsuarioRepository;
import com.isitsafe.models.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Transactional
	public Usuario create(Usuario usuario) {
		return this.repository.save(usuario);
	}
	
	public List<Usuario> readAll() {
		return this.repository.findAll();
	}
	
	public Optional<Usuario> read(Long id) {
		return this.repository.findById(id);
	}
	
	@Transactional
	public Usuario update(Long id, Usuario usuario) {
		usuario.setId(id);
		return this.repository.save(usuario);
	}
	
	@Transactional
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}