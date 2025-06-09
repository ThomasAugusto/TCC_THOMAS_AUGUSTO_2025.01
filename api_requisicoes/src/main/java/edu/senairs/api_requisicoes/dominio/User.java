package edu.senairs.api_requisicoes.dominio;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    private String id;
    private String name;
    private String email;

    public User(UserDTO userData) {
        this.name = userData.name();
        this.email = userData.email();
    }
}
