package br.ufrn.SmartRecibos.repository;

import br.ufrn.SmartRecibos.model.Recibo;
import br.ufrn.SmartRecibos.model.StatusRecibo;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReciboRepository extends JpaRepository<Recibo, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Recibo r SET r.status = :novoStatus WHERE r.id = :id")
    int syncStatus(@Param("id") Long id, @Param("novoStatus") StatusRecibo novoStatus);

    Page<Recibo> findAll(Pageable pageable);

}
