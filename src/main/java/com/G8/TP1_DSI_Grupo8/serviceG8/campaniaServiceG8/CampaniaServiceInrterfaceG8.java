package com.G8.TP1_DSI_Grupo8.serviceG8.campaniaServiceG8;

import com.G8.TP1_DSI_Grupo8.entityG8.CampaniaG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ClientePotencialG8;
import com.G8.TP1_DSI_Grupo8.entityG8.MiembroCampaniaG8;
import com.G8.TP1_DSI_Grupo8.DAOG8.CampaniaDAOG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.clientePotencialG8.ClientePotencialServiceImplementG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaniaServiceInrterfaceG8 implements CampaniaServiceInterfaceG8{

    @Autowired
    private CampaniaDAOG8 campaniaRepository;

    @Autowired
    private ClientePotencialServiceImplementG8 clientePotencialServiceImplementG8;


    @Override
    public List<CampaniaG8> obtenerTodas() {
        try {
            return campaniaRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al querer traer las campañas", e);
        }
    }

    @Override
    public CampaniaG8 guardar(CampaniaG8 campania) {
        try {
            campaniaRepository.save(campania);
            return campania;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al guardar la campaña", e);
        }
    }

    @Override
    public List<CampaniaG8> buscarPorNombre(String nombre) {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El parámetro de búsqueda no puede estar vacío.");
            }
            return campaniaRepository.findByNombreCampaniaContainingIgnoreCase(nombre);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar campañas por nombre", e);
        }
    }

    @Override
    public Optional<CampaniaG8> findById(Long idCampania) {
        try{
            return campaniaRepository.findById(idCampania);
        }catch (RuntimeException e){
            throw new RuntimeException("error al buscar campanisa por id", e);
        }
    }

    @Override
    public MiembroCampaniaG8 asociarClienteACampania(Long idCampania, Long idCliente) {
        try {

            CampaniaG8 campania = campaniaRepository.findById(idCampania)
                    .orElseThrow(() -> new RuntimeException("campania no encontrada" ));


            ClientePotencialG8 cliente = clientePotencialServiceImplementG8.findById(idCliente)
                    .orElseThrow(() -> new RuntimeException("cliente no encontrado"));


            MiembroCampaniaG8 miembro = new MiembroCampaniaG8();
            miembro.setCampania(campania);
            miembro.setClientePotencial(cliente);


            campania.getMiembrosCampania().add(miembro);


            campaniaRepository.save(campania);

            return miembro;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al asociar cliente a la campaña", e);
        }
    }



}
