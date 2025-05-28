package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.Mascota;
import com.example.mundomascota.services.MascotaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController extends AbstractController<Mascota,Long> {
    public MascotaController(MascotaService svc){ super(svc); }
}
