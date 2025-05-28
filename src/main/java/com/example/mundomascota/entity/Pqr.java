package com.example.mundomascota.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pqr")
public class Pqr {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPqr;

    @ManyToOne @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @NotNull
    @Enumerated(EnumType.STRING) @Column(length = 20)
    private TipoPqr tipo;

    private String descripcion;

    @NotNull @PastOrPresent
    private LocalDate fecha;

    @NotNull @Enumerated(EnumType.STRING) @Column(length = 20)
    private EstadoPqr estado = EstadoPqr.NUEVO;

    public enum TipoPqr { PETICION, QUEJA, RECLAMO }
    public enum EstadoPqr { NUEVO, EN_REVISION, CERRADO }

    // Getters & setters...
}
