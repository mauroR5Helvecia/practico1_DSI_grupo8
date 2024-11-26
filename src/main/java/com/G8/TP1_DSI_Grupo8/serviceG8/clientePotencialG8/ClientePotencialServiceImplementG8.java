package com.G8.TP1_DSI_Grupo8.serviceG8.clientePotencialG8;

import com.G8.TP1_DSI_Grupo8.DAOG8.CampaniaDAOG8;
import com.G8.TP1_DSI_Grupo8.DTOG8.ClientePotencialDTOG8;
import com.G8.TP1_DSI_Grupo8.entityG8.CampaniaG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ClientePotencialG8;
import com.G8.TP1_DSI_Grupo8.DAOG8.ClientePotencialDAOG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientePotencialServiceImplementG8 implements ClientePotencialInterfaceG8 {


    @Autowired
    private ClientePotencialDAOG8 clientePotencialRepository;

    @Autowired
    private CampaniaDAOG8 campaniaDAOG8;


    @Override
    public Optional<ClientePotencialG8> findById(Long idCliente) {
        try{
            return clientePotencialRepository.findById(idCliente);
        }catch (RuntimeException e){
            throw new RuntimeException("error al buscar cliente potencial por id", e);
        }
    }

    @Override
    public List<ClientePotencialG8> obtenerTodos() {
        try {
            return clientePotencialRepository.findAll();
        }catch (RuntimeException e){
            throw new RuntimeException("Error al querer traer los clientes potenciales", e);
        }
    }

    @Override
    public ClientePotencialG8 guardar(ClientePotencialDTOG8 clientePotencialDTO) {
        try {
            // Crear una nueva instancia de ClientePotencialG8
            ClientePotencialG8 clientePotencial = new ClientePotencialG8();

            // Mapear los datos del DTO a la entidad
            clientePotencial.setNombre(clientePotencialDTO.getNombre());
            clientePotencial.setApellido(clientePotencialDTO.getApellido());
            clientePotencial.setEmail(clientePotencialDTO.getEmail());


            if (clientePotencialDTO.getNombreCampania() != null && !clientePotencialDTO.getNombreCampania().isEmpty()) {
                CampaniaG8 campania = campaniaDAOG8.findByNombreCampaniaContainingIgnoreCase(clientePotencialDTO.getNombreCampania())
                        .stream()
                        .findFirst() // Tomar la primera campaña encontrada
                        .orElseThrow(() -> new RuntimeException("Campaña no encontrada con el nombre: " + clientePotencialDTO.getNombreCampania()));

                clientePotencial.setCampania(campania);
            }

            // Guardar el cliente potencial en el repositorio
            return clientePotencialRepository.save(clientePotencial);

        } catch (RuntimeException e) {
            throw new RuntimeException("Error al guardar un cliente potencial", e);
        }
    }



}
