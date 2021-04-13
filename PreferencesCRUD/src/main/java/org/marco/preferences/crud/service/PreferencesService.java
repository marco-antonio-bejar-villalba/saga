package org.marco.preferences.crud.service;

import org.marco.preferences.crud.entities.CustomerProperties;
import org.marco.preferences.crud.models.Response;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PreferencesService {
	Mono<Response> create(CustomerProperties properties);

	Flux<CustomerProperties> fetchAll();

	Mono<CustomerProperties> fetchOne(String clientId);

	Mono<Response> delete(String id);

	Mono<CustomerProperties> update(CustomerProperties properties);
}
