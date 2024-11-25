package com.G8.TP1_DSI_Grupo8.serviceG8.casoServiceG8;

import com.G8.TP1_DSI_Grupo8.entityG8.CasoG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ContactoG8;
import com.G8.TP1_DSI_Grupo8.repositoryG8.CasoRepositoryG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.contactoServiceG8.ContactoServiceImplementG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasoServiceImplementG8 implements CasoServiceInterfaceG8 {

    @Autowired
    private CasoRepositoryG8 casoRepository;

    @Autowired
    private ContactoServiceImplementG8 contactoServiceImplementG8;



    @Override
    public List<CasoG8> obtenerTodos() {
        try {
            return casoRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al obtener todos los casos", e);
        }
    }

    @Override
    public CasoG8 guardar(CasoG8 caso) {
        try {
//            Vamos a validar que cuando se quiera guardar un caso, este este asociado si o si a un contacto
            if (caso.getContacto() == null) {
                throw new RuntimeException("El caso debe estar asociado a un contacto.");
            }
            return casoRepository.save(caso);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al guardar el caso", e);
        }
    }



    @Override
    public CasoG8 registrarCaso(Long idContacto) {
        try {
            ContactoG8 contacto = contactoServiceImplementG8.buscarPorId(idContacto);

            CasoG8 caso = new CasoG8();
            caso.setContacto(contacto);
            return casoRepository.save(caso);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al registrar caso", e);
        }
    }
}
