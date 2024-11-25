package com.G8.TP1_DSI_Grupo8.controller;
import com.G8.TP1_DSI_Grupo8.entityG8.ContactoG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.contactoServiceG8.ContactoServiceInterfaceG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacto")
public class ContactoControllerG8 {

    @Autowired
    private ContactoServiceInterfaceG8 contactoService;

    @PostMapping("/save")
    public ContactoG8 guardarContacto(@RequestBody ContactoG8 contacto) {
        try {
            return contactoService.guardar(contacto);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al guardar el contacto", e);
        }
    }

    @GetMapping("/todos")
    public List<ContactoG8> obtenerTodos() {
        try {
            return contactoService.obtenerTodos();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al obtener todos los contactos", e);
        }
    }

    @GetMapping("/{id}")
    public ContactoG8 buscarPorId(@PathVariable Long id) {
        try {
            return contactoService.buscarPorId(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar el contacto con ID: " + id, e);
        }
    }

}
