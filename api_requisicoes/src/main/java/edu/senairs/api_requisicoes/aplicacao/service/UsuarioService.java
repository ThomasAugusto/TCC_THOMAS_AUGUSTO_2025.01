package edu.senairs.api_requisicoes.aplicacao.service;

import edu.senairs.api_requisicoes.adaptadores.saidas.repository.MongoUsuariosRepository;
import edu.senairs.api_requisicoes.entidades.AutentificadorDTO;
import edu.senairs.api_requisicoes.entidades.MongoUsuario;
import edu.senairs.api_requisicoes.entidades.RegristroDTO;
import edu.senairs.api_requisicoes.infraestrutura.seguranca.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private MongoUsuariosRepository mongoDbRep;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public boolean emailUsuarioEhCadastrado(RegristroDTO data){
        return mongoDbRep.findByEmailUsuario(data.email()) != null;
    }

    public void cadastrarUsuario(RegristroDTO data){
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        MongoUsuario Novousuario = new MongoUsuario(data.nome(), data.email(), encryptedPassword, data.tipoUsuario().getTipoUsuario());

        this.mongoDbRep.save(Novousuario);
    }

    public String autentificarUsuario(AutentificadorDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var autentificacao = this.authenticationManager.authenticate(usernamePassword);

        return tokenService.geradorToken((MongoUsuario) autentificacao.getPrincipal());
    }
}
