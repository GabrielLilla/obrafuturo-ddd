package br.com.fiap.obrafuturo.infrastructure.repository;

import br.com.fiap.obrafuturo.domain.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {
}
