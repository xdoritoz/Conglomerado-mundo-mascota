package com.example.mundomascota.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "historial_servicio")
public class HistorialServicio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;

    @ManyToOne @JoinColumn(name = "id_mascota", nullable = false)
    private Mascota mascota;

    @ManyToOne @JoinColumn(name = "id_servicio", nullable = false)
    private Servicio servicio;

    @ManyToOne @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotNull
    @PastOrPresent
    private LocalDate fecha;

    private String observaciones;

}
