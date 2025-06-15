package edu.senairs.api_requisicoes.aplicacao.service;

import edu.senairs.api_requisicoes.adaptadores.saidas.repository.MongoUsuariosRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutorizacaoService implements UserDetailsService {

    final MongoUsuariosRepository mongoDbRep;

    public AutorizacaoService(MongoUsuariosRepository mongoDbRep) {
        this.mongoDbRep = mongoDbRep;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mongoDbRep.findByEmailUsuario(username);
    }
}
