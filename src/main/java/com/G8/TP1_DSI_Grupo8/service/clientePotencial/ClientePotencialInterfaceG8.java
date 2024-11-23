package com.G8.TP1_DSI_Grupo8.service.clientePotencial;

import com.G8.TP1_DSI_Grupo8.entity.ClientePotencialG8;

import java.util.List;

public interface ClientePotencialInterfaceG8 {

    public List<ClientePotencialG8> obtenerTodos();

    public ClientePotencialG8 guardar(ClientePotencialG8 clientePotencial);
}
