package com.example.mundomascota.controllers;

import com.example.mundomascota.entity.Cliente;
import com.example.mundomascota.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clientes")
public class ClienteViewController {

    private final ClienteService clienteService;

    public ClienteViewController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "clientes/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/form";
    }

    @PostMapping("/guardar")
    public String guardarCliente(
            @Valid @ModelAttribute("cliente") Cliente cliente,
            BindingResult result,
            RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "clientes/form";
        }
        try {
            clienteService.save(cliente);
            redirect.addFlashAttribute("exito", "Cliente guardado exitosamente.");
        } catch (DataIntegrityViolationException ex) {
            result.rejectValue("documento", "error.documento", "Ya existe un cliente con este documento.");
            return "clientes/form";
        }
        return "redirect:/clientes";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Cliente c = clienteService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("cliente", c);
        return "clientes/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id, RedirectAttributes redirect) {
        try {
            clienteService.delete(id);
            redirect.addFlashAttribute("exito", "Cliente eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirect.addFlashAttribute("error", "No se puede eliminar: tiene mascotas asociadas.");
        }
        return "redirect:/clientes";
    }
}
