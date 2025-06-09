package edu.senairs.api_requisicoes.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    @Id
    private String idStudent;
    private String nameStudent;
    private Email emailStudent;
    private String passwordStudent;
    private CPF cpfStudent;
    private Phone phoneStudent;

    public Student(StudentRequestDTO user) {
        this.nameStudent = user.name();
        this.emailStudent = new Email(user.email());
        this.passwordStudent = user.password();
        this.cpfStudent = new CPF(user.cpf());
        this.phoneStudent = new Phone(user.phoneNumber());
    }
}
