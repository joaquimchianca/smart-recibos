package br.ufrn.SmartRecibos.repository;

import br.ufrn.SmartRecibos.model.Cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c " +
            "LEFT JOIN FETCH c.telefone t " +
            "LEFT JOIN FETCH c.endereco e " +
            "WHERE c.id = :id")
    Cliente findByIdWithDetails(@Param("id") Long id);

    Page<Cliente> findAll(Pageable pageable);
}
