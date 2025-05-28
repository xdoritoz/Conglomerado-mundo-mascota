package com.example.mundomascota.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reporte")
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReporte;

    @NotNull
    @Enumerated(EnumType.STRING) @Column(length = 30)
    private TipoReporte tipo;

    @NotNull
    private LocalDate fechaGeneracion;

    private String descripcion;

    @ManyToOne @JoinColumn(name = "generado_por", nullable = false)
    private Usuario generadoPor;

    public enum TipoReporte {
        PQR_QUINCENAL, SERVICIOS_SEMANALES, TOP_RAZAS, GANANCIAS
    }

}
