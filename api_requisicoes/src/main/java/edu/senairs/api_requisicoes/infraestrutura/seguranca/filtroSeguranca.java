package edu.senairs.api_requisicoes.infraestrutura.seguranca;

import edu.senairs.api_requisicoes.repository.MongoUsuariosRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class filtroSeguranca extends OncePerRequestFilter {
    final
    TokenService tokenService;
    final
    MongoUsuariosRepository mongoDbRep;

    public filtroSeguranca(TokenService tokenService, MongoUsuariosRepository mongoDbRep) {
        this.tokenService = tokenService;
        this.mongoDbRep = mongoDbRep;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var token = this.recoverToken(request);
        if(token != null){
            var email = tokenService.validarToken(token);
            UserDetails usuario = mongoDbRep.findByEmailUsuario(email);

            var autentificacao = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autentificacao);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}
