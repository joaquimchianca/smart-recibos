package br.ufrn.SmartRecibos.repository;

import br.ufrn.SmartRecibos.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRequest extends JpaRepository<Endereco, Integer> {
}
