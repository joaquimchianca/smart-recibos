package br.ufrn.SmartRecibos.repository;

import br.ufrn.SmartRecibos.model.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReciboRepository extends JpaRepository<Recibo, Long> {
}
