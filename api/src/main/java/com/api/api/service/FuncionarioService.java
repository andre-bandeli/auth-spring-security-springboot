package com.api.api.service;

import com.api.api.model.Funcionarios;
import com.api.api.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    public Funcionarios saveFuncionario(Funcionarios funcionarios) {
        return funcionariosRepository.save(funcionarios);
    }

    public List<Funcionarios> getFuncionarios() {
        return funcionariosRepository.findAll();
    }
}
