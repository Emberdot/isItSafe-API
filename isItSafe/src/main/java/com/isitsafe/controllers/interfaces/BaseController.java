package com.isitsafe.controllers.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseController<T> {
	public ResponseEntity<List<T>> index();
	public ResponseEntity<Optional<T>> show(@PathVariable(name = "id") Long id);
	public ResponseEntity<T> store(@RequestBody T object);
	public ResponseEntity<T> update(@PathVariable(name = "id") Long id, @RequestBody T object);
	public ResponseEntity<String> destroy(@PathVariable(name = "id") Long id);
}