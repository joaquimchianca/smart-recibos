package br.ufrn.SmartRecibos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.SmartRecibos.model.Cliente;
import br.ufrn.SmartRecibos.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente entityT) {

        return clienteRepository.save(entityT);
    }

}
