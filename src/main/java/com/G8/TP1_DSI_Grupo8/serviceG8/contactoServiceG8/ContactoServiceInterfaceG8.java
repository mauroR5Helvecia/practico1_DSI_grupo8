package com.G8.TP1_DSI_Grupo8.serviceG8.contactoServiceG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ContactoG8;
import java.util.List;

public interface ContactoServiceInterfaceG8 {

    List<ContactoG8> obtenerTodos();

    ContactoG8 guardar(ContactoG8 contacto);

    ContactoG8 buscarPorId(Long idContacto);
}
