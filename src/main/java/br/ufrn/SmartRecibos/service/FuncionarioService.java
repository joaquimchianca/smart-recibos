package br.ufrn.SmartRecibos.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import br.ufrn.SmartRecibos.model.Funcionario;
import br.ufrn.SmartRecibos.repository.FuncionarioRepository;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Funcionario não encontrado com o id: " + id
        ));
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
