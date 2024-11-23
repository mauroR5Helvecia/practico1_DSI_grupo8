package com.G8.TP1_DSI_Grupo8.service.clientePotencial;

import com.G8.TP1_DSI_Grupo8.entity.ClientePotencialG8;
import com.G8.TP1_DSI_Grupo8.repository.ClientePotencialRepositoryG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientePotencialServiceImplementG8 implements ClientePotencialInterfaceG8 {


    @Autowired
    private ClientePotencialRepositoryG8 clientePotencialRepository;

    @Override
    public List<ClientePotencialG8> obtenerTodos() {
        try {
            return clientePotencialRepository.findAll();
        }catch (RuntimeException e){
            throw new RuntimeException("Error al querer traer los clientes potenciales", e);
        }
    }

    @Override
    public ClientePotencialG8 guardar(ClientePotencialG8 clientePotencial) {
        try{
            clientePotencialRepository.save(clientePotencial);
            return clientePotencial;
        }catch (RuntimeException e){
            throw new RuntimeException("Error al guardar un cliente potencial");
        }
    }



}
