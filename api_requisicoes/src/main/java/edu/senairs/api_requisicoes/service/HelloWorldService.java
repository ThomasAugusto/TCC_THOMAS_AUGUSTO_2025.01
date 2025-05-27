package edu.senairs.api_requisicoes.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String sayHello(String name) {
        return "Hello World!" + name;
    }
}
