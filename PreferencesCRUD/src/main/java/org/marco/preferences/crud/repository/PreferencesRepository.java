package org.marco.preferences.crud.repository;

import org.marco.preferences.crud.entities.Client;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PreferencesRepository extends ReactiveCrudRepository<Client, Integer> {

}
