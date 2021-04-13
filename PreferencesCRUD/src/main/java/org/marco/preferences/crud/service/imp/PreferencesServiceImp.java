package org.marco.preferences.crud.service.imp;

import java.util.Objects;
import java.util.Optional;

import org.marco.preferences.crud.entities.CustomerProperties;
import org.marco.preferences.crud.models.Response;
import org.marco.preferences.crud.repository.PreferencesRepository;
import org.marco.preferences.crud.service.PreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class PreferencesServiceImp implements PreferencesService {
	@Autowired
	private PreferencesRepository repository;

	@Override
	public Mono<Response> create(CustomerProperties properties) {
		String clientId = properties.getClientId();
		validateClientId(clientId);
		return repository.existsById(clientId).flatMap(exists -> {
			if (exists) {
				throw new IllegalArgumentException("Is required a valid clientID");
			}
			return repository.save(properties);
		}).onErrorMap(exc -> new IllegalArgumentException("Eeexxxiiitoo"))
				.map(client -> new Response(client.getClientId()));
//		return repository.existsById(clientId)
//				.doOnSuccess(exists -> generateExceptionIfTrue(exists, "Client already exists."))
//				.then(repository.save(properties)).map(prop -> new Response(prop.getClientId()));

	}

	private void validateClientId(String clientId) {
		Optional.ofNullable(clientId).orElseThrow(() -> new IllegalArgumentException("Is required a valid clientID"));
	}

	@Override
	public Flux<CustomerProperties> fetchAll() {
		return repository.findAll();
	}

	@Override
	public Mono<CustomerProperties> fetchOne(String clientId) {
		validateClientId(clientId);
		return repository.findById(clientId)
				.doOnSuccess(client -> generateExceptionIfTrue(Objects.isNull(client), "Client does not exist."));
	}

	@Override
	public Mono<Response> delete(String id) {
		validateClientId(id);
		return repository.findById(id)
				.doOnSuccess(client -> generateExceptionIfTrue(Objects.isNull(client), "Client does not exist."))
				.then(repository.deleteById(id)).thenReturn(new Response(id));

	}

	@Override
	public Mono<CustomerProperties> update(CustomerProperties properties) {
		validateClientId(properties.getClientId());
		log.warn(properties.toString());
		return repository.existsById(properties.getClientId())
				.doOnSuccess(exists -> generateExceptionIfTrue(!exists, "Client does not exist."))
				.then(repository.save(properties));
	}

	private void generateExceptionIfTrue(Boolean test, String message) {
		if (test)
			throw new IllegalArgumentException(message);
	}

}
