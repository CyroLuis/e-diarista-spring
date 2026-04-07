package br.com.treinaweb.ediaristas.core.repository;

import br.com.treinaweb.ediaristas.core.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Servico, Long> {
}
