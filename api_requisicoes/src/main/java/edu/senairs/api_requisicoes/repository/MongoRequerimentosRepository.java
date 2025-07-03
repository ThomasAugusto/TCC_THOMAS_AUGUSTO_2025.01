package edu.senairs.api_requisicoes.repository;

import edu.senairs.api_requisicoes.entidades.requerimentos.RequerimentoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRequerimentosRepository extends MongoRepository<RequerimentoMongo, String> {
}
