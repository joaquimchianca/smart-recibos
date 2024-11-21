package br.ufrn.SmartRecibos.controller;

import br.ufrn.SmartRecibos.model.Cliente;
import br.ufrn.SmartRecibos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar() {
        Cliente cliente = new Cliente();

        if (cliente.getNome().equals("Joao")) {
            throw new RuntimeException("nao pode ter cliente com nome de Joao");
        }
        clienteService.save(cliente);
    }
}
