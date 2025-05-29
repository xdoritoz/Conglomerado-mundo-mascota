package com.example.mundomascota.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMascota;

    @NotBlank
    @Size(max = 100)
    private String nombre;

    @NotBlank @Size(max = 50)
    private String raza;

    @NotBlank @Size(max = 50)
    private String especie;

    @Min(0)
    private Integer edad;

    @DecimalMin("0.0")
    private double peso;

    @ManyToOne @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;


}