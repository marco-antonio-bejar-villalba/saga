package org.marco.preferences.crud.controller;

import org.marco.preferences.crud.entities.CustomerProperties;
import org.marco.preferences.crud.models.Response;
import org.marco.preferences.crud.service.PreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/customer/delivery/properties")
@Slf4j
public class CrudController {

	@Autowired
	private PreferencesService service;

	@GetMapping("/all")
	public Flux<CustomerProperties> getAll() {
		return service.fetchAll();
	}

	@PostMapping()
	public Mono<Response> createOne(@RequestBody CustomerProperties properties) {
		log.warn(properties.toString());
		return service.create(properties);
	}

	@GetMapping("/{id}")
	public Mono<CustomerProperties> getOne(@PathVariable String id) {
		return service.fetchOne(id);
	}

	@PutMapping
	public Mono<CustomerProperties> update(@RequestBody CustomerProperties properties) {
		return service.update(properties);
	}

	@DeleteMapping("/{id}")
	public Mono<Response> delete(@PathVariable String id) {
		log.warn(id);
		return service.delete(id);
	}
}
