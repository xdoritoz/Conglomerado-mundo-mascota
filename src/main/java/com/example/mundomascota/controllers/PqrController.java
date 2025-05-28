package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.Pqr;
import com.example.mundomascota.services.PqrService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pqrs")
public class PqrController extends AbstractController<Pqr,Long> {
    public PqrController(PqrService svc){ super(svc); }
}