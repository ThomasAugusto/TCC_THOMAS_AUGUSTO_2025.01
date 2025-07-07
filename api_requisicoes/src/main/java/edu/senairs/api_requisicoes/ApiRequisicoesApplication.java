package edu.senairs.api_requisicoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories()
public class ApiRequisicoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRequisicoesApplication.class, args);
	}

	

}
