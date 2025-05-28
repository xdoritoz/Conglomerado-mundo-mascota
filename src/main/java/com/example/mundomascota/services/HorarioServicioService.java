package com.example.mundomascota.services;

import com.example.mundomascota.entity.HorarioServicio;
import com.example.mundomascota.repositories.HorarioServicioRepository;
import org.springframework.stereotype.Service;

@Service
public class HorarioServicioService extends AbstractService<HorarioServicio,Long> {
    public HorarioServicioService(HorarioServicioRepository r){ super(r); }
}
