package br.ufrn.SmartRecibos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.SmartRecibos.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
