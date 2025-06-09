package edu.senairs.api_requisicoes.adaptadores.entradas.controller;

import edu.senairs.api_requisicoes.adaptadores.saidas.repository.MongoUsuariosRepositorio;
import edu.senairs.api_requisicoes.dominio.AutentificadorDTO;
import edu.senairs.api_requisicoes.dominio.MongoUsuario;
import edu.senairs.api_requisicoes.dominio.RegristroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutentificacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MongoUsuariosRepositorio mongoDbRep;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AutentificadorDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var autentificacao = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity registraUsuario(@RequestBody RegristroDTO data){
        if(mongoDbRep.findByEmailUsuario(data.email()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        MongoUsuario Novousuario = new MongoUsuario(data.nome(), data.email(), encryptedPassword, data.tipoUsuario());

        this.mongoDbRep.save(Novousuario);

        return ResponseEntity.ok().build();
    }
}
