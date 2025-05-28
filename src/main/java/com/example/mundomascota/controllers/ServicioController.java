package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.Servicio;
import com.example.mundomascota.services.ServicioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController extends AbstractController<Servicio,Long> {
    public ServicioController(ServicioService svc){ super(svc); }
}
