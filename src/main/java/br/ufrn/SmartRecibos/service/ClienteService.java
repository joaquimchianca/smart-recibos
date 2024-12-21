package br.ufrn.SmartRecibos.service;

import br.ufrn.SmartRecibos.dto.request.ClienteRequest;
import br.ufrn.SmartRecibos.model.Endereco;
import br.ufrn.SmartRecibos.model.Telefone;
import br.ufrn.SmartRecibos.repository.EnderecoRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.ufrn.SmartRecibos.model.Cliente;
import br.ufrn.SmartRecibos.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    public ClienteService(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public Cliente save(ClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setNome(request.nome());
        cliente.setCpfCnpj(request.cpfCnpj());
        cliente.setEmail(request.email());
        cliente.setPj(request.isPj());
        cliente.setAtivo(request.isAtivo());

        Endereco endereco = enderecoRepository.findById(request.enderecoId())
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));
        cliente.setEndereco(endereco);

        List<Telefone> telefones = request.telefone().stream()
                .map(telefoneRequest -> {
                    Telefone telefone = new Telefone();
                    telefone.setNumero(telefoneRequest.numero());
                    telefone.setCliente(cliente);
                    return telefone;
                })
                .toList();
        cliente.setTelefone(telefones);
        return clienteRepository.save(cliente);
    }

    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cliente não encontrado com o id: " + id));
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
