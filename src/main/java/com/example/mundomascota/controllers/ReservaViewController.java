package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.Reserva;
import com.example.mundomascota.services.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaViewController {

    private final ReservaService reservaService;

    public ReservaViewController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public String listarReservas(Model model) {
        model.addAttribute("reservas", reservaService.listarTodas());
        return "reservas/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservas/form";
    }

    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute("reserva") Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Reserva reserva = reservaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID no válido: " + id));
        model.addAttribute("reserva", reserva);
        return "reservas/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        reservaService.eliminar(id);
        return "redirect:/reservas";
    }
}
