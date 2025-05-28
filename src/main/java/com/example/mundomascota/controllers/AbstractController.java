package com.example.mundomascota.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

public abstract class AbstractController<T, ID> {
    protected final com.example.mundomascota.services.AbstractService<T, ID> service;
    protected AbstractController(com.example.mundomascota.services.AbstractService<T, ID> svc) {
        this.service = svc;
    }

    @GetMapping
    public List<T> list() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable ID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<T> create(@Valid @RequestBody T dto) {
        T saved = service.save(dto);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @Valid @RequestBody T dto) {
        return service.findById(id)
                .map(existing -> {
                    // assume DTO has setId method
                    try {
                        dto.getClass().getMethod("set" + /*Id capitalized*/ "")
                                .invoke(dto, id);
                    } catch (Exception ignored){}
                    return ResponseEntity.ok(service.save(dto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

