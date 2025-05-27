package edu.senairs.api_requisicoes.controller;

import edu.senairs.api_requisicoes.domain.User;
import edu.senairs.api_requisicoes.domain.UserDTO;
import edu.senairs.api_requisicoes.service.UserServiceaa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserServiceaa service;

    public UserController(UserServiceaa service) {
        this.service = service;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<User> insert(@RequestBody UserDTO userData) {
        User newUser = this.service.insert(userData);
        return ResponseEntity.ok().body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = this.service.getAll();
        return ResponseEntity.ok().body(users);
    }
}
