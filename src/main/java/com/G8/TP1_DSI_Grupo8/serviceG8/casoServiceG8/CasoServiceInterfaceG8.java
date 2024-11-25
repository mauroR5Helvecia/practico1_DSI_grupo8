package com.G8.TP1_DSI_Grupo8.serviceG8.casoServiceG8;
import com.G8.TP1_DSI_Grupo8.entityG8.CasoG8;
import java.util.List;

public interface CasoServiceInterfaceG8 {

    List<CasoG8> obtenerTodos();

    CasoG8 guardar(CasoG8 caso);

    CasoG8 registrarCaso(Long idContacto);
}
