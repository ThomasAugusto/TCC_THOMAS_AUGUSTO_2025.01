package edu.senairs.api_requisicoes.adaptadores.saidas.repository;

import edu.senairs.api_requisicoes.entidades.requerimentos.MongoRequerimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRequerimentosRepository extends MongoRepository<MongoRequerimento, String> {
}
