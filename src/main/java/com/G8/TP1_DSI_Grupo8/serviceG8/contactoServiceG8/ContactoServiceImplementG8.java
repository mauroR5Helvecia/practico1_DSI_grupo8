package com.G8.TP1_DSI_Grupo8.serviceG8.contactoServiceG8;

import com.G8.TP1_DSI_Grupo8.entityG8.ContactoG8;
import com.G8.TP1_DSI_Grupo8.repositoryG8.ContactoRepositoryG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServiceImplementG8 implements ContactoServiceInterfaceG8 {

    @Autowired
    private ContactoRepositoryG8 contactoRepository;

    @Override
    public List<ContactoG8> obtenerTodos() {
        try {
            return contactoRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("error al obtener todos los contactos", e);
        }
    }

    @Override
    public ContactoG8 guardar(ContactoG8 contacto) {
        try {
            if (contacto.getCuenta() == null) {
                throw new RuntimeException("el contacto debe estar asociado a una cuenta.");
            }
            return contactoRepository.save(contacto);
        } catch (RuntimeException e) {
            throw new RuntimeException("error al guardar el contacto", e);
        }
    }

    @Override
    public ContactoG8 buscarPorId(Long idContacto) {
        try {
            return contactoRepository.findById(idContacto)
                    .orElseThrow(() -> new RuntimeException("contacto no encontrado"));
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar el contacto", e);
        }
    }
}
