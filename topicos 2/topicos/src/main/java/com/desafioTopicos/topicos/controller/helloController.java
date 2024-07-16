package com.desafioTopicos.topicos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RestController
public class helloController {
    @GetMapping("/hello")
    public  String HELLO(){
        return "Hello World";
    }
}
