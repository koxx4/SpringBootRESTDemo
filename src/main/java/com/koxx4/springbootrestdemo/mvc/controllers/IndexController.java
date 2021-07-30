package com.koxx4.springbootrestdemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    private String displayWelcomePage(){
        return "index";
    }

}
