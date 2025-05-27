package edu.senairs.api_requisicoes.service;

import edu.senairs.api_requisicoes.domain.User;
import edu.senairs.api_requisicoes.domain.UserDTO;
import edu.senairs.api_requisicoes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceaa {
    private UserRepository userRepository;

    public UserServiceaa(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insert(UserDTO userData){
        User user = new User(userData);
        this.userRepository.save(user);
        return user;
    }

    public List<User> getAll(){
        return this.userRepository.findAll();
    }
}
