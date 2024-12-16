package br.ufrn.SmartRecibos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.ufrn.SmartRecibos.model.Funcionario;
import br.ufrn.SmartRecibos.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("v1/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }

    @GetMapping
    public List<Funcionario> findAll() {
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public Funcionario findById(@PathVariable Long id) {
        return funcionarioService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        funcionarioService.delete(id);
    }
}
