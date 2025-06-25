package edu.senairs.api_requisicoes.adaptadores.saidas.repository;

import edu.senairs.api_requisicoes.entidades.usuarios.MongoUsuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUsuariosRepository extends MongoRepository<MongoUsuario, String> {
    UserDetails findByEmailUsuario(String email);
}
