package com.autentication.autentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/home")
public class HomePageController {

    @GetMapping
    public String home() {
        return "Você está logado";
    }
}
