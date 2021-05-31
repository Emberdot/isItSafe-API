package com.isitsafe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isitsafe.models.Genero;
import com.isitsafe.repositories.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repository;
	
	@Transactional
	public Genero create(Genero genero) {
		return this.repository.save(genero);
	}
	
	public List<Genero> readAll() {
		return this.repository.findAll();
	}
	
	public Optional<Genero> read(Long id) {
		return this.repository.findById(id);
	}
	
	@Transactional
	public Genero update(Long id, Genero genero) {
		genero.setId(id);
		return this.repository.save(genero);
	}
	
	@Transactional
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}