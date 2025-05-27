package edu.senairs.api_requisicoes.service;

import edu.senairs.api_requisicoes.domain.Student;
import edu.senairs.api_requisicoes.domain.StudentRequestDTO;
import edu.senairs.api_requisicoes.domain.StudentResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IUserService<StudentRequestDTO, StudentResponseDTO> {

    @Override
    public String insertUser(StudentRequestDTO user) {
        Student student = new Student(user);
        return "";
    }

    @Override
    public String updateUser(StudentRequestDTO user) {
        return "";
    }

    @Override
    public String deleteUser(String id) {
        return "";
    }

    @Override
    public List<StudentResponseDTO> findAll() {
        return List.of();
    }
}
