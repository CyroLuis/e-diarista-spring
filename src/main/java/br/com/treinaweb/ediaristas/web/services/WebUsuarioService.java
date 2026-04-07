package br.com.treinaweb.ediaristas.web.services;

import br.com.treinaweb.ediaristas.core.models.Usuario;
import br.com.treinaweb.ediaristas.core.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebUsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }
}
