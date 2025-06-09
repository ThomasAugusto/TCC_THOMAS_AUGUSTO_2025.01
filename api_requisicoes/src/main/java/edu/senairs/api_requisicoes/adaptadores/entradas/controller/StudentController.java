package edu.senairs.api_requisicoes.adaptadores.entradas.controller;

import edu.senairs.api_requisicoes.dominio.StudentRequestDTO;
import edu.senairs.api_requisicoes.aplicacao.service.StudentService;
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
