package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.Mascota;
import com.example.mundomascota.entity.Cliente;
import com.example.mundomascota.services.MascotaService;
import com.example.mundomascota.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mascotas")
public class MascotaViewController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.findAll());
        return "mascotas/list";
    }

    @GetMapping("/nuevo")
    public String nuevaMascota(Model model) {
        Mascota mascota = new Mascota();
        mascota.setCliente(new Cliente());  // inicializa para el binding
        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.findAll());
        return "mascotas/form";
    }

    @GetMapping("/editar/{id}")
    public String editarMascota(@PathVariable Long id, Model model) {
        Mascota mascota = mascotaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.findAll());
        return "mascotas/form";
    }

    @PostMapping("/guardar")
    public String guardarMascota(@ModelAttribute Mascota mascota, RedirectAttributes redirect) {
        mascotaService.save(mascota);
        redirect.addFlashAttribute("mensaje", "Mascota guardada con éxito.");
        return "redirect:/mascotas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable Long id, RedirectAttributes redirect) {
        mascotaService.delete(id);
        redirect.addFlashAttribute("mensaje", "Mascota eliminada correctamente.");
        return "redirect:/mascotas";
    }
}
