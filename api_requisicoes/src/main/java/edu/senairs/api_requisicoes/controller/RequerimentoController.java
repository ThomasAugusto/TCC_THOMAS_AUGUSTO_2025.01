package edu.senairs.api_requisicoes.controller;

import edu.senairs.api_requisicoes.entidades.requerimentos.CancelamentoMatriculaDTO;
import edu.senairs.api_requisicoes.service.RequerimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/requerimentos")
public class RequerimentoController {

    @Autowired
    private RequerimentoService requerimentoService;

    @PostMapping("/cancelamento-matricula")
    public ResponseEntity solicitarCancelamentoMatricula(@RequestBody CancelamentoMatriculaDTO data){
        requerimentoService.solicitarCancelamentoMatricula(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public ResponseEntity listarRequerimentos(){
        return ResponseEntity.ok(requerimentoService.listarRequerimentos());
    }
}
