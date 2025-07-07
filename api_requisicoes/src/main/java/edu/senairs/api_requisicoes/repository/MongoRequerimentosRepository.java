package edu.senairs.api_requisicoes.repository;

import edu.senairs.api_requisicoes.entidades.requerimentos.MongoRequerimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoRequerimentosRepository extends MongoRepository<MongoRequerimento, String> {
    @Query("{ 'estado': ?0 }")
    List<MongoRequerimento> findAllByEstadoProcesso(String estadoProcesso);
}
