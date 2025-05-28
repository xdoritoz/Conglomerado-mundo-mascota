package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.HistorialServicio;
import com.example.mundomascota.services.HistorialServicioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/historial")
public class HistorialServicioController extends AbstractController<HistorialServicio,Long> {
    public HistorialServicioController(HistorialServicioService svc){ super(svc); }
}
