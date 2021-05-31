package com.isitsafe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isitsafe.models.Sexualidade;
import com.isitsafe.repositories.SexualidadeRepository;

@Service
public class SexualidadeService {

	@Autowired
	private SexualidadeRepository repository;
	
	@Transactional
	public Sexualidade create(Sexualidade sexualidade) {
		return this.repository.save(sexualidade);
	}
	
	public List<Sexualidade> readAll() {
		return this.repository.findAll();
	}
	
	public Optional<Sexualidade> read(Long id) {
		return this.repository.findById(id);
	}
	
	@Transactional
	public Sexualidade update(Long id, Sexualidade sexualidade) {
		sexualidade.setId(id);
		return this.repository.save(sexualidade);
	}
	
	@Transactional
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}