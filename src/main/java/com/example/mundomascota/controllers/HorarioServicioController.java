package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.HorarioServicio;
import com.example.mundomascota.services.HorarioServicioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/horarios")
public class HorarioServicioController extends AbstractController<HorarioServicio,Long> {
    public HorarioServicioController(HorarioServicioService svc){ super(svc); }
}
