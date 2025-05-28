package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.Cliente;
import com.example.mundomascota.services.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController extends AbstractController<Cliente,Long> {
    public ClienteController(ClienteService svc){ super(svc); }
}
