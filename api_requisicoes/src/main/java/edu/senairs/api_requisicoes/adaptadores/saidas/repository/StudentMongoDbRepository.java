package edu.senairs.api_requisicoes.adaptadores.saidas.repository;

import edu.senairs.api_requisicoes.dominio.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMongoDbRepository extends MongoRepository<Student, String> {
}
