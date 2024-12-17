package br.ufrn.SmartRecibos.service;

import br.ufrn.SmartRecibos.dto.ClienteRequest;
import br.ufrn.SmartRecibos.model.Endereco;
import br.ufrn.SmartRecibos.model.Telefone;
import org.springframework.stereotype.Service;

import br.ufrn.SmartRecibos.model.Cliente;
import br.ufrn.SmartRecibos.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente save(ClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setNome(request.nome());
        cliente.setCpfCnpj(request.cpfCnpj());
        cliente.setEmail(request.email());
        cliente.setPj(request.isPj());
        cliente.setAtivo(request.isAtivo());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(request.endereco().logradouro());
        endereco.setNumero(request.endereco().numero());
        endereco.setBairro(request.endereco().bairro());
        endereco.setCidade(request.endereco().cidade());
        endereco.setEstado(request.endereco().estado());
        endereco.setCep(request.endereco().cep());
        endereco.setComplemento(request.endereco().complemento());
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

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
