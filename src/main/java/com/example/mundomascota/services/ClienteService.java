package com.example.mundomascota.services;

import com.example.mundomascota.entity.Cliente;
import com.example.mundomascota.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends AbstractService<Cliente,Long> {
    public ClienteService(ClienteRepository r){ super(r); }
}
