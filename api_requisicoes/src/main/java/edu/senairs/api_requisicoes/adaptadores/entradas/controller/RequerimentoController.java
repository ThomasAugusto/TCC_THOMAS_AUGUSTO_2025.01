package edu.senairs.api_requisicoes.adaptadores.entradas.controller;

import edu.senairs.api_requisicoes.aplicacao.service.RequerimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/requerimentos")
public class RequerimentoController {

    @Autowired
    private RequerimentoService requerimentoService;

    @GetMapping("/listar")
    public ResponseEntity listarRequerimentos(){
        return ResponseEntity.ok().build();
    }
}
