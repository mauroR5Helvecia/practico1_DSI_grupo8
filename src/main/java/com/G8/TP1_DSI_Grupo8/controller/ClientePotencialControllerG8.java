package com.G8.TP1_DSI_Grupo8.controller;
import com.G8.TP1_DSI_Grupo8.entityG8.ClientePotencialG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.clientePotencialG8.ClientePotencialInterfaceG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cliente-potencial")
public class ClientePotencialControllerG8 {

    @Autowired
    private ClientePotencialInterfaceG8 clientePotencialInterfaceG8;


    @PostMapping("/save")
    public String SaveClientePotencial (@RequestBody ClientePotencialG8 cliente){
        try{

            ClientePotencialG8 clienteResponse =clientePotencialInterfaceG8.guardar(cliente);

            return clienteResponse.toString();

        }catch (RuntimeException e){
            throw new RuntimeException("Hubo un error al guardar el cliente", e);

        }
    }

    @GetMapping("/traerclientespotenciales")
    public List<ClientePotencialG8> traerClientesPotenciales(){
        try {
            return clientePotencialInterfaceG8.obtenerTodos();
        }catch (RuntimeException e){
            throw new RuntimeException("Hubo un error al traer la lista de clientes potenciales", e);
        }
    }


}
