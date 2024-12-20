package br.ufrn.SmartRecibos.repository;

import br.ufrn.SmartRecibos.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
