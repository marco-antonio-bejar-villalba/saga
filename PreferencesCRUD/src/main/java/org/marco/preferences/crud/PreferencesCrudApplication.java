package org.marco.preferences.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class PreferencesCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreferencesCrudApplication.class, args);
	}

}
