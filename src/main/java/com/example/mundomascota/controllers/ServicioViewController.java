package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.Servicio;
import com.example.mundomascota.services.ServicioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicios")
public class ServicioViewController {

    private final ServicioService servicioService;

    public ServicioViewController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public String listarServicios(Model model) {
        model.addAttribute("servicios", servicioService.findAll());
        return "servicios/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicios/form";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Servicio servicio = servicioService.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        model.addAttribute("servicio", servicio);
        return "servicios/form";
    }

    @PostMapping("/guardar")
    public String guardarServicio(@Valid @ModelAttribute("servicio") Servicio servicio,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            return "servicios/form";
        }
        servicioService.save(servicio);
        return "redirect:/servicios";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable Long id) {
        servicioService.delete(id);
        return "redirect:/servicios";
    }
}
