package org.marco.preferences.crud.repository;

import org.marco.preferences.crud.entities.CustomerProperties;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends ReactiveMongoRepository<CustomerProperties, String> {

}
