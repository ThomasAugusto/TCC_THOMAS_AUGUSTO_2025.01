package edu.senairs.api_requisicoes.service;

import edu.senairs.api_requisicoes.entidades.requerimentos.CancelamentoMatriculaDTO;
import edu.senairs.api_requisicoes.entidades.requerimentos.Entidades;
import edu.senairs.api_requisicoes.entidades.requerimentos.RequerimentoMongo;
import edu.senairs.api_requisicoes.entidades.usuarios.Aluno;
import edu.senairs.api_requisicoes.repository.MongoRequerimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequerimentoService {

    @Autowired
    private MongoRequerimentosRepository mongoDbRep;

    public void solicitarCancelamentoMatricula(CancelamentoMatriculaDTO data){
        if (!data.tipoUsuario().equals("aluno")){
            throw new IllegalArgumentException("O tipo de usuário não é válido para solicitar cancelamento de matrícula");
        }

        String protocolo = "123456789";
        String estado = "Solicitado";

        Aluno aluno = new Aluno(data.nomeAluno(), data.emailAluno(),
                data.telefoneAluno(), data.emailAluno(), data.curso(), data.motivoCancelamento());
        Entidades alunoWrapper = new Entidades(aluno);
        RequerimentoMongo requerimentoMongo = new RequerimentoMongo(protocolo, estado, alunoWrapper);
        mongoDbRep.save(requerimentoMongo);
    }

    public Object listarRequerimentos() {
        return mongoDbRep.findAll();
    }
}
