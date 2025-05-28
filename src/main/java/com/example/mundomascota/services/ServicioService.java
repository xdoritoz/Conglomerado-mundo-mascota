package com.example.mundomascota.services;

import com.example.mundomascota.entity.Servicio;
import com.example.mundomascota.repositories.ServicioRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicioService extends AbstractService<Servicio,Long> {
    public ServicioService(ServicioRepository r){ super(r); }
}
