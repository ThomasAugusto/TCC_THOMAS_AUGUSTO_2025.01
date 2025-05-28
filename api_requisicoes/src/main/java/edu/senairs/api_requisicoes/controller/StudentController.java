package edu.senairs.api_requisicoes.controller;

import edu.senairs.api_requisicoes.domain.StudentRequestDTO;
import edu.senairs.api_requisicoes.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> registerStudent(@RequestBody StudentRequestDTO studentData){
        String newStudent = this.studentService.insertUser(studentData);
        return ResponseEntity.ok().body(newStudent);
    }
}
