package edu.senairs.api_requisicoes.dominio;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class MongoUsuario implements UserDetails {
    @Id
    private String idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private TipoUsuario tipoUsuario;

    public MongoUsuario(String nome, String email, String password, TipoUsuario tipoUsuario) {
        this.nomeUsuario = nome;
        this.emailUsuario = email;
        this.senhaUsuario = password;
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // TODO se sobrar tempo, implementar permissoes separadas por entidade.
        if (this.tipoUsuario == TipoUsuario.ADMINISTRADOR){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return senhaUsuario;
    }

    @Override
    public String getUsername() {
        return nomeUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
