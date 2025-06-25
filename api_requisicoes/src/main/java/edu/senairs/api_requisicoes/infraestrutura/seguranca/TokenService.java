package edu.senairs.api_requisicoes.infraestrutura.seguranca;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import edu.senairs.api_requisicoes.entidades.usuarios.MongoUsuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value( "${api.security.token.secret}")
    private String secret;

    public String geradorToken(MongoUsuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("API Requisicoes")
                    .withSubject(usuario.getEmailUsuario())
                    .withClaim("email", usuario.getEmailUsuario())
                    .withClaim("nome", usuario.getNomeUsuario())
                    .withClaim("tipoUsuario", usuario.getTipoUsuario())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    public String validarToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API Requisicoes")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            return "";
        }
    }

    private Instant genExpirationDate(){
        int DURACAO_TOKEN_HORAS = 1;
        String FUSO_HORARIO_BRASILIA = "-03:00";
        return LocalDateTime.now().plusHours(DURACAO_TOKEN_HORAS).toInstant(ZoneOffset.of(FUSO_HORARIO_BRASILIA));
    }


}
