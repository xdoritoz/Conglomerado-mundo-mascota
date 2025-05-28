package com.example.mundomascota.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servicio")
public class Servicio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;

    @NotBlank @Size(max = 100)
    private String nombre;

    private String descripcion;

    @NotNull
    @DecimalMin("0.0")
    private Double precio;

    @NotNull @Enumerated(EnumType.STRING) @Column(length = 30)
    private Segmento segmento;

    @Size(max = 50)
    private String subRubro;

    public enum Segmento { CLINICA, HOTEL, SPA }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public @NotBlank @Size(max = 100) String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank @Size(max = 100) String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public @NotNull @DecimalMin("0.0") Double getPrecio() {
        return precio;
    }

    public void setPrecio(@NotNull @DecimalMin("0.0") Double precio) {
        this.precio = precio;
    }

    public @NotNull Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(@NotNull Segmento segmento) {
        this.segmento = segmento;
    }

    public @Size(max = 50) String getSubRubro() {
        return subRubro;
    }

    public void setSubRubro(@Size(max = 50) String subRubro) {
        this.subRubro = subRubro;
    }
}

