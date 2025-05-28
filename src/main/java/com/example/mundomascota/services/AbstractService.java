package com.example.mundomascota.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, ID> {
    protected final org.springframework.data.jpa.repository.JpaRepository<T, ID> repo;
    protected AbstractService(org.springframework.data.jpa.repository.JpaRepository<T, ID> repo) {
        this.repo = repo;
    }
    public List<T> findAll() { return repo.findAll(); }
    public Optional<T> findById(ID id) { return repo.findById(id); }
    public T save(T entity) { return repo.save(entity); }
    public void delete(ID id) { repo.deleteById(id); }
}
