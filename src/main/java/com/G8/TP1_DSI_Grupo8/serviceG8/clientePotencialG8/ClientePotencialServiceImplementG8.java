package com.G8.TP1_DSI_Grupo8.serviceG8.clientePotencialG8;

import com.G8.TP1_DSI_Grupo8.entityG8.ClientePotencialG8;
import com.G8.TP1_DSI_Grupo8.repositoryG8.ClientePotencialRepositoryG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientePotencialServiceImplementG8 implements ClientePotencialInterfaceG8 {


    @Autowired
    private ClientePotencialRepositoryG8 clientePotencialRepository;


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
    public ClientePotencialG8 guardar(ClientePotencialG8 clientePotencial) {
        try{
            clientePotencialRepository.save(clientePotencial);
            return clientePotencial;
        }catch (RuntimeException e){
            throw new RuntimeException("Error al guardar un cliente potencial");
        }
    }



}
