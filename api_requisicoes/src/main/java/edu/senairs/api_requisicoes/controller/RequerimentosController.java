package edu.senairs.api_requisicoes.controller;

import edu.senairs.api_requisicoes.entidades.processos.CancelamentoMatriculaDTO;
import edu.senairs.api_requisicoes.entidades.processos.TrancamentoMatriculaDTO;
import edu.senairs.api_requisicoes.entidades.requerimentos.MongoRequerimento;
import edu.senairs.api_requisicoes.entidades.requerimentos.ObservacaoDTO;
import edu.senairs.api_requisicoes.entidades.usuarios.DadosAlunoDTO;
import edu.senairs.api_requisicoes.service.RequerimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/requerimentos")
public class RequerimentosController {

    private final RequerimentoService requerimentoService;

    public RequerimentosController(RequerimentoService requerimentoService) {
        this.requerimentoService = requerimentoService;
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<MongoRequerimento>> listarRequerimentos(@PathVariable String id){
        List<MongoRequerimento> lista = requerimentoService.listarRequerimentos(id);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/usuario/{idUsuario}/requerimento/{idRequerimento}")
    public ResponseEntity<MongoRequerimento> obterRequerimento(@PathVariable String idUsuario, @PathVariable String idRequerimento,
                                                               @RequestBody(required = false)ObservacaoDTO data){
        requerimentoService.atualizarRequerimento(idUsuario, idRequerimento, data);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/usuario/{idUsuario}/requerimento/{idRequerimento}/revisar")
    public ResponseEntity<MongoRequerimento> revisarDadosAluno(@PathVariable String idUsuario, @PathVariable String idRequerimento,
                                                               @RequestBody(required = false)ObservacaoDTO data){
        requerimentoService.enviarParaRevisarDados(idUsuario, idRequerimento, data);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/aluno/{idUsuario}/requerimento/{idRequerimento}")
    public ResponseEntity<MongoRequerimento> atualizarDadosAluno(@PathVariable String idUsuario, @PathVariable String idRequerimento,
                                                                 @RequestBody DadosAlunoDTO data){
        requerimentoService.atualizarDadosAluno(idUsuario, idRequerimento, data);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cancelamento-matricula")
    public ResponseEntity cancelarMatricula(@RequestBody CancelamentoMatriculaDTO data){
        requerimentoService.solicitarCancelamentoMatricula(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/trancamento-matricula")
    public ResponseEntity trancarMatricula(@RequestBody TrancamentoMatriculaDTO data){
        requerimentoService.solicitarTrancamentoMatricula(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
