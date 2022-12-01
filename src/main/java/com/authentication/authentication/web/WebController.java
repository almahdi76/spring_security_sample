package com.authentication.authentication.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/admin")
    public String pageAdmin(){
        return "page prive celle de l'admin";
    }
    @GetMapping("/users")
    public String pageUser(){
        return "page prive celle de l'User";
    }
    @GetMapping("/")
    public String pagePubli(){
        return "page public celle du visiteur";
    }
}
