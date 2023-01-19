package com.api.api.controller;

import com.api.api.model.Empresa;
import com.api.api.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/add")
    public Empresa adicionaEmpresaController(@RequestBody Empresa empresa) {
        return empresaService.salvarEmpresa(empresa);
    }

    @PostMapping("/add/list")
    public List<Empresa> salvarListaEmpresasController(@RequestBody List<Empresa> empresaList){
        return empresaService.salvarListaEmpresas(empresaList);
    }

    @GetMapping("/list")
    public List<Empresa> getEmpresasController(){
        return empresaService.getEmpresas();
    }

    @GetMapping("/list/{id}")
    public Optional getEMpresaByIdController(@PathVariable Long id) {
        return empresaService.getEmpresaById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmpresaByIdController(@PathVariable Long id) {
        empresaService.deleteEmpresaById(id);
        return "Empresa id: " + id + " deletado!";
    }

    @PutMapping("/update/{id}")
    public String updateEmpresaByIdController(@PathVariable Long id,
                                              @RequestBody Empresa empresa) {
        empresaService.updateEmpresaById(id, empresa);
        return "Empresa " + empresa.getNome() + " atualizada com sucesso!";
    }

}
