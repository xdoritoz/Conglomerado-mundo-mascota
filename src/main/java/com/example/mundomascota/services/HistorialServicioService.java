package com.example.mundomascota.services;

import com.example.mundomascota.entity.HistorialServicio;
import com.example.mundomascota.repositories.HistorialServicioRepository;
import org.springframework.stereotype.Service;

@Service
public class HistorialServicioService extends AbstractService<HistorialServicio,Long> {
    public HistorialServicioService(HistorialServicioRepository r){ super(r); }
}