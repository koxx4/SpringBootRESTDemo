package com.koxx4.springbootrestdemo.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/hello")
    private String handleGetHelloService(){

        return "Hello rest world!";
    }

}
