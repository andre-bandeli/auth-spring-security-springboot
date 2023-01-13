package com.autentication.autentication.controller;

import com.autentication.autentication.model.User;
import com.autentication.autentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User saveUser(@RequestBody User user) {
        return userService.saveUsuario(user);
    }

    @GetMapping("/list")
    public List<User> listUser() {
        return userService.listUsers();
    }

    @GetMapping("/listById")
    public Optional listUser(@PathVariable Long id) {
        return userService.listUsuarioById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "Usuário deletado!";
    }

}
