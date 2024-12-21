package br.ufrn.SmartRecibos.controller;

import br.ufrn.SmartRecibos.dto.request.ClienteRequest;
import br.ufrn.SmartRecibos.model.Cliente;
import br.ufrn.SmartRecibos.service.ClienteService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @PostMapping
    public Cliente save(@RequestBody ClienteRequest cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
