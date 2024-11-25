package com.G8.TP1_DSI_Grupo8.serviceG8.campaniaServiceG8;

import com.G8.TP1_DSI_Grupo8.entityG8.CampaniaG8;
import com.G8.TP1_DSI_Grupo8.entityG8.MiembroCampaniaG8;

import java.util.List;
import java.util.Optional;

public interface CampaniaServiceInterfaceG8 {

    public List<CampaniaG8> obtenerTodas();

    public CampaniaG8 guardar(CampaniaG8 campania);

    List<CampaniaG8> buscarPorNombre(String nombre);

    public Optional<CampaniaG8> findById(Long idCampania);

    public MiembroCampaniaG8 asociarClienteACampania(Long idCampania, Long idCliente);

}
