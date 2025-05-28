package com.example.mundomascota.services;

import com.example.mundomascota.entity.Pqr;
import com.example.mundomascota.repositories.PqrRepository;
import org.springframework.stereotype.Service;

@Service
public class PqrService extends AbstractService<Pqr,Long> {
    public PqrService(PqrRepository r){ super(r); }
}
