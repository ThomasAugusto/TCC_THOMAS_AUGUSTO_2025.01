package edu.senairs.api_requisicoes.aplicacao.service;

import edu.senairs.api_requisicoes.dominio.Student;
import edu.senairs.api_requisicoes.dominio.StudentRequestDTO;
import edu.senairs.api_requisicoes.dominio.StudentResponseDTO;
import edu.senairs.api_requisicoes.adaptadores.saidas.repository.StudentMongoDbRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IUserService<StudentRequestDTO, StudentResponseDTO> {
    StudentMongoDbRepository studentRepository;

    public StudentService(StudentMongoDbRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String insertUser(StudentRequestDTO user) {
        Student student = new Student(user);
        studentRepository.save(student);
        return student.getIdStudent();
    }

    @Override
    public String updateUser(StudentRequestDTO user) {
        return "";
    }

    @Override
    public String deleteUserById(String id) {
        return "";
    }

    @Override
    public List<StudentResponseDTO> findAll() {
        return List.of();
    }
}
