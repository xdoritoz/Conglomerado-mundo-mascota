package com.example.mundomascota.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuario")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotBlank
    private String nombre;

    @Email @NotBlank @Column(unique = true)
    private String correo;

    @NotBlank
    private String contraseña;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private TipoUsuario tipoUsuario;

    public enum TipoUsuario {
        GERENTE, EMPLEADO_HOTEL, ADMIN_CLINICA, AUXILIAR_SPA, PUBLICO
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public @NotBlank String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public @Email @NotBlank String getCorreo() {
        return correo;
    }

    public void setCorreo(@Email @NotBlank String correo) {
        this.correo = correo;
    }

    public @NotBlank String getContraseña() {
        return contraseña;
    }

    public void setContraseña(@NotBlank String contraseña) {
        this.contraseña = contraseña;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}

