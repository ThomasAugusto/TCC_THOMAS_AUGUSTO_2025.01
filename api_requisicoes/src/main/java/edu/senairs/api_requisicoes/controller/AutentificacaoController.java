package edu.senairs.api_requisicoes.controller;

import edu.senairs.api_requisicoes.service.UsuarioService;
import edu.senairs.api_requisicoes.entidades.usuarios.autentificacao.AutentificadorDTO;
import edu.senairs.api_requisicoes.entidades.usuarios.autentificacao.LoginResponseDTO;
import edu.senairs.api_requisicoes.entidades.usuarios.autentificacao.RegristroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class AutentificacaoController {

    private final UsuarioService usuarioService;

    public AutentificacaoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AutentificadorDTO data){
        String token = this.usuarioService.autentificarUsuario(data);
        var usuario = this.usuarioService.getUsuarioByToken(token);
        return ResponseEntity.ok(new LoginResponseDTO(token, usuario.getIdUsuario()));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity registraUsuario(@RequestBody RegristroDTO data){
        if(this.usuarioService.emailUsuarioEhCadastrado(data)){
            return ResponseEntity.badRequest().build();
        }
        this.usuarioService.cadastrarUsuario(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
