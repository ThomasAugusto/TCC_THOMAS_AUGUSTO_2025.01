package edu.senairs.api_requisicoes.controller;

import edu.senairs.api_requisicoes.domain.User;
import edu.senairs.api_requisicoes.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping
    public String helloWorld() {
       return helloWorldService.sayHello("Thomas");
   }

   @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "none") String filter, @RequestBody User body) {
        return "Hello World Post" + filter;
   }

}
