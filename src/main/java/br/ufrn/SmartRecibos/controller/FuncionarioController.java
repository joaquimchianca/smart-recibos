package br.ufrn.SmartRecibos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.SmartRecibos.model.Funcionario;
import br.ufrn.SmartRecibos.service.FuncionarioService;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {

        return funcionarioService.save(funcionario);

    }

}
