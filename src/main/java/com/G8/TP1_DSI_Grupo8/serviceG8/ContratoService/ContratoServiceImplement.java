package com.G8.TP1_DSI_Grupo8.serviceG8.ContratoService;

import com.G8.TP1_DSI_Grupo8.DAOG8.ContratoDAOG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ContratoG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoServiceImplement implements ContratoServiceInterface{

    @Autowired
    private ContratoDAOG8 contratoDAOG8;


    @Override
    public ContratoG8 guardar(ContratoG8 contratoG8) {
        try{
            return contratoDAOG8.save(contratoG8);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al guardar el contrato", e);
        }
    }
}
