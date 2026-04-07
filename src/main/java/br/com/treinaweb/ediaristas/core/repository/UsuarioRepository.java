package br.com.treinaweb.ediaristas.core.repository;

import br.com.treinaweb.ediaristas.core.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
