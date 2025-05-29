package com.example.mundomascota.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter @Setter
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotBlank @Size(max = 100)
    private String nombre;

    @NotBlank @Size(max = 100)
    private String apellido;

    @NotBlank @Size(max = 50)
    @Column(unique = true)
    private String documento;

    @Size(max = 150)
    private String direccion;

    @Size(max = 20)
    private String telefono;

    @Email @Size(max = 100)
    private String correo;
}
