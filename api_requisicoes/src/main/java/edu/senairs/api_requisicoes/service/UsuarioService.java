package edu.senairs.api_requisicoes.service;

import edu.senairs.api_requisicoes.repository.MongoUsuariosRepository;
import edu.senairs.api_requisicoes.entidades.usuarios.autentificacao.AutentificadorDTO;
import edu.senairs.api_requisicoes.entidades.usuarios.autentificacao.MongoUsuario;
import edu.senairs.api_requisicoes.entidades.usuarios.autentificacao.RegristroDTO;
import edu.senairs.api_requisicoes.infraestrutura.seguranca.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final MongoUsuariosRepository mongoDbRep;

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    public UsuarioService(MongoUsuariosRepository mongoDbRep, TokenService tokenService, AuthenticationManager authenticationManager) {
        this.mongoDbRep = mongoDbRep;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    public boolean emailUsuarioEhCadastrado(RegristroDTO data){
        return mongoDbRep.findByEmailUsuario(data.email()) != null;
    }

    public void cadastrarUsuario(RegristroDTO data){
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        MongoUsuario Novousuario = new MongoUsuario(data.nome(), data.email(),
                                    encryptedPassword, data.tipoUsuario().getTipoUsuario());

        this.mongoDbRep.save(Novousuario);
    }

    public String autentificarUsuario(AutentificadorDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var autentificacao = this.authenticationManager.authenticate(usernamePassword);

        return tokenService.geradorToken((MongoUsuario) autentificacao.getPrincipal());
    }
    
    public MongoUsuario getUsuarioByToken(String token) {
        String email = tokenService.validarToken(token);
        MongoUsuario usuario = (MongoUsuario) mongoDbRep.findByEmailUsuario(email);
        usuario.toString();
        return usuario;
    }
}
