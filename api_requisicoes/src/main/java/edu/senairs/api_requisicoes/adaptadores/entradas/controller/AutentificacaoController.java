package edu.senairs.api_requisicoes.adaptadores.entradas.controller;

import edu.senairs.api_requisicoes.aplicacao.service.UsuarioService;
import edu.senairs.api_requisicoes.entidades.AutentificadorDTO;
import edu.senairs.api_requisicoes.entidades.LoginResponseDTO;
import edu.senairs.api_requisicoes.entidades.RegristroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class AutentificacaoController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AutentificadorDTO data){
        String token = this.usuarioService.autentificarUsuario(data);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity registraUsuario(@RequestBody RegristroDTO data){
        if(this.usuarioService.emailUsuarioEhCadastrado(data)){
            return ResponseEntity.badRequest().build();
        }
        this.usuarioService.cadastrarUsuario(data);
        return ResponseEntity.ok().build();
    }
}
