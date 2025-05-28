package com.example.mundomascota.services;
import com.example.mundomascota.entity.Cliente;
import com.example.mundomascota.entity.Mascota;
import com.example.mundomascota.repositories.ClienteRepository;
import com.example.mundomascota.repositories.MascotaRepository;
import org.springframework.stereotype.Service;

@Service public class MascotaService extends AbstractService<Mascota,Long> {
    public MascotaService(MascotaRepository r){ super(r); }
}
