package edu.senairs.api_requisicoes.controller;

import edu.senairs.api_requisicoes.entidades.requerimentos.CancelamentoMatriculaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public class RequerimentoController {
    @RequestMapping("/requerimentos")

    @PostMapping("/cancelamento-matricula")
    public ResponseEntity solicitarCancelamentoMatricula(@RequestBody CancelamentoMatriculaDTO data){

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
