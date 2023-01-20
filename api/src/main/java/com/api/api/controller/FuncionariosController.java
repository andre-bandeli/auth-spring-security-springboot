package com.api.api.controller;

import com.api.api.model.Funcionarios;
import com.api.api.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/funcionario")
public class FuncionariosController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/add")
    public Funcionarios saveFuncionario(@RequestBody Funcionarios funcionarios) {
        return funcionarioService.saveFuncionario(funcionarios);
    }

    @GetMapping("/list")
    public List<Funcionarios> getFuncionarios() {
        return funcionarioService.getFuncionarios();
    }
}
