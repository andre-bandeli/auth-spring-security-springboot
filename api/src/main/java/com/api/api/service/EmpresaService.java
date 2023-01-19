package com.api.api.service;

import com.api.api.model.Empresa;
import com.api.api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;


    public Empresa salvarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> salvarListaEmpresas(List<Empresa> empresaList) {
        return empresaRepository.saveAll(empresaList);
    }

    public List<Empresa> getEmpresas() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> getEmpresaById(Long id) {
        return empresaRepository.findById(id);
    }

    public void deleteEmpresaById(Long id) {
        empresaRepository.deleteById(id);
    }

    public String updateEmpresaById(Long id, Empresa empresa) {

        Empresa updateEmpresa = empresaRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("usuário não encontrado -> id null"));
        updateEmpresa.setNome(empresa.getNome());
        updateEmpresa.setSigla(empresa.getSigla());
        empresaRepository.save(updateEmpresa);
        return "Dados da empresa" + updateEmpresa.getNome() + "atualizados!";
    }
}
