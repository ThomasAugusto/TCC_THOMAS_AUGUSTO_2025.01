package edu.senairs.api_requisicoes.aplicacao.service;

import edu.senairs.api_requisicoes.adaptadores.saidas.repository.MongoUsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutorizacaoServico implements UserDetailsService {

    @Autowired
    MongoUsuariosRepositorio mongoDbRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mongoDbRep.findByEmailUsuario(username);
    }
}
