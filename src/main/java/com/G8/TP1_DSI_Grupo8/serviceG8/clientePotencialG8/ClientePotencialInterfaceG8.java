package com.G8.TP1_DSI_Grupo8.serviceG8.clientePotencialG8;

import com.G8.TP1_DSI_Grupo8.entityG8.ClientePotencialG8;

import java.util.List;
import java.util.Optional;

public interface ClientePotencialInterfaceG8 {

    public Optional<ClientePotencialG8> findById(Long idCliente);

    public List<ClientePotencialG8> obtenerTodos();

    public ClientePotencialG8 guardar(ClientePotencialG8 clientePotencial);
}
