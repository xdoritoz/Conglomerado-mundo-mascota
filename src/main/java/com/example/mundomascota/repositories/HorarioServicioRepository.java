package com.example.mundomascota.repositories;
import com.example.mundomascota.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioServicioRepository extends JpaRepository<HorarioServicio, Long> {}