package com.example.loginpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "/index.html";
    }
    @RequestMapping("/login")
    public String login(){
        return "/login.html";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "/logout.html";
    }

    @GetMapping("/user")
    public String user(){
        return "/user.html";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/admin.html";
    }

}
