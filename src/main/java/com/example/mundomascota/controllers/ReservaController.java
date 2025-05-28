package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.Reserva;
import com.example.mundomascota.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;


@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("reservas", reservaService.listarTodas());
        return "index";
    }

    @PostMapping("/reservar")
    public String guardarReserva(@ModelAttribute("reserva") Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        reservaService.eliminar(id);
        return "redirect:/";
    }
}