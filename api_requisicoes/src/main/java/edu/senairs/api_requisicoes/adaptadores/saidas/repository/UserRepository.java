package edu.senairs.api_requisicoes.adaptadores.saidas.repository;

import edu.senairs.api_requisicoes.dominio.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
