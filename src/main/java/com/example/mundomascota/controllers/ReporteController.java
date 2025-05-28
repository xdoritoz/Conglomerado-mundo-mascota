package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.Reporte;
import com.example.mundomascota.services.ReporteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController extends AbstractController<Reporte,Long> {
    public ReporteController(ReporteService svc){ super(svc); }
}
