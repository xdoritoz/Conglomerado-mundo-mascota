package com.example.mundomascota.services;

import com.example.mundomascota.entity.Reporte;
import com.example.mundomascota.repositories.ReporteRepository;
import org.springframework.stereotype.Service;

@Service
public class ReporteService extends AbstractService<Reporte,Long> {
    public ReporteService(ReporteRepository r){ super(r); }
}
