package com.example.mundomascota.services;

import com.example.mundomascota.entity.Usuario;
import com.example.mundomascota.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> findAll() {
        return repo.findAll();
    }
    public Optional<Usuario> findById(Long id) {
        return repo.findById(id);
    }
    public Usuario save(Usuario u) {
        return repo.save(u);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
