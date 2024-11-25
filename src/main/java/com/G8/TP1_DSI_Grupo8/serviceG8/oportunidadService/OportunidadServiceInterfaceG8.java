package com.G8.TP1_DSI_Grupo8.serviceG8.oportunidadService;
import com.G8.TP1_DSI_Grupo8.entityG8.OportunidadG8;
import com.G8.TP1_DSI_Grupo8.entityG8.RolOportunidadG8;

import java.util.List;

public interface OportunidadServiceInterfaceG8 {

    List<OportunidadG8> obtenerTodas();

    OportunidadG8 guardar(OportunidadG8 oportunidad);

    OportunidadG8 buscarPorId(Long idOportunidad);

    List<OportunidadG8> buscarPorEtapa(String etapaOportunidad);

    OportunidadG8 crearOportunidad(Long idCuenta, String etapa, String detalles);

    RolOportunidadG8 asociarContactoAOportunidad(Long idOportunidad, Long idContacto);
}
