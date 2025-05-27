package edu.senairs.api_requisicoes.domain;

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
    }
}
