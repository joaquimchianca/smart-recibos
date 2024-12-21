package br.ufrn.SmartRecibos.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import br.ufrn.SmartRecibos.model.Funcionario;
import br.ufrn.SmartRecibos.service.FuncionarioService;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Funcionarios", description = "Endpoints para manipulação de Funcionários")
@RestController
@RequestMapping("v1/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADM')")
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADM')")
    public List<Funcionario> findAll() {
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADM')")
    public Funcionario findById(@PathVariable Long id) {
        return funcionarioService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADM')")
    public void delete(@PathVariable Long id) {
        funcionarioService.delete(id);
    }
}
