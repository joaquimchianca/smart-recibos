package br.ufrn.SmartRecibos.controller;

import br.ufrn.SmartRecibos.dto.request.ClienteRequest;
import br.ufrn.SmartRecibos.model.Cliente;
import br.ufrn.SmartRecibos.service.ClienteService;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cliente", description = "API de Clientes")
@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> findAll(Pageable pageable) {
        return clienteService.findAll(pageable).getContent();
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
