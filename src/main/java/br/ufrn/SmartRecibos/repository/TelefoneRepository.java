package br.ufrn.SmartRecibos.repository;

import br.ufrn.SmartRecibos.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
