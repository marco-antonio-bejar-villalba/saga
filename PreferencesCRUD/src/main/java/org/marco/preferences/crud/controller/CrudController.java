package org.marco.preferences.crud.controller;

import org.marco.preferences.crud.entities.CustomerProperties;
import org.marco.preferences.crud.repository.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	private PreferencesRepository repository;

	@GetMapping("/all")
	public Flux<CustomerProperties> getAll() {
		return repository.findAll();
	}

	@PostMapping()
	public Mono<String> createOne(@RequestBody CustomerProperties properties) {
		log.warn(properties.toString());
		return repository.save(properties).map(prop -> prop.getId());
	}
}
