package com.example.loginpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginPageApplication.class, args);

//        System.out.println(new BCryptPasswordEncoder().encode("teste"));
    }

}
