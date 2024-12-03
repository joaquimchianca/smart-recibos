package br.ufrn.SmartRecibos.repository;

import br.ufrn.SmartRecibos.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
