package edu.senairs.api_requisicoes.aplicacao.service;

import edu.senairs.api_requisicoes.adaptadores.saidas.repository.MongoRequerimentosRepository;
import edu.senairs.api_requisicoes.entidades.requerimentos.MongoRequerimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequerimentoService {

    @Autowired
    private MongoRequerimentosRepository mongoDbRepository;

    public void solicitarRequerimento(MongoRequerimento data){
        this.mongoDbRepository.save(data);
    }
}
