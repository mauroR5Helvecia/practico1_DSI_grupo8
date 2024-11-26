package com.G8.TP1_DSI_Grupo8.serviceG8.oportunidadService;

import com.G8.TP1_DSI_Grupo8.entityG8.ContactoG8;
import com.G8.TP1_DSI_Grupo8.entityG8.OportunidadG8;
import com.G8.TP1_DSI_Grupo8.entityG8.RolOportunidadG8;
import com.G8.TP1_DSI_Grupo8.DAOG8.OportunidadDAOG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.contactoServiceG8.ContactoServiceImplementG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OportunidadServiceImplementG8 implements OportunidadServiceInterfaceG8 {

    @Autowired
    private OportunidadDAOG8 oportunidadRepository;

    @Autowired
    private ContactoServiceImplementG8 contactoServiceImplementG8;

    @Override
    public List<OportunidadG8> obtenerTodas() {
        try {
            return oportunidadRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("error al obtener todas las oportunidades", e);
        }
    }

    @Override
    public OportunidadG8 guardar(OportunidadG8 oportunidad) {
        try {
            if (oportunidad.getCuenta() == null) {
                throw new RuntimeException(";a oportunidad debe estar asociada a una cuenta.");
            }
            return oportunidadRepository.save(oportunidad);
        } catch (RuntimeException e) {
            throw new RuntimeException("error al guardar la oportunidad", e);
        }
    }

    @Override
    public OportunidadG8 buscarPorId(Long idOportunidad) {
        try {
            return oportunidadRepository.findById(idOportunidad)
                    .orElseThrow(() -> new RuntimeException("oportunidad no encontrada"));
        } catch (RuntimeException e) {
            throw new RuntimeException("error al buscar la oportunidad con ID: " + idOportunidad, e);
        }
    }

    @Override
    public List<OportunidadG8> buscarPorEtapa(String etapaOportunidad) {
        try {
            return oportunidadRepository.findByEtapaOportunidadContainingIgnoreCase(etapaOportunidad);
        } catch (RuntimeException e) {
            throw new RuntimeException("error al buscar oportunidades por etapa: " + etapaOportunidad, e);
        }
    }



    @Override
    public OportunidadG8 crearOportunidad(Long idCuenta, String etapa, String detalles) {
        try {
            OportunidadG8 oportunidad = new OportunidadG8();
            oportunidad.setEtapaOportunidad(etapa);
            oportunidad.setDetallesOportunidad(detalles);
            return oportunidadRepository.save(oportunidad);
        } catch (RuntimeException e) {
            throw new RuntimeException("error al crear oportunidad", e);
        }
    }

    @Override
    public RolOportunidadG8 asociarContactoAOportunidad(Long idOportunidad, Long idContacto) {
        try {
            OportunidadG8 oportunidad = oportunidadRepository.findById(idOportunidad)
                    .orElseThrow(() -> new RuntimeException("Oportunidad no encontrada" ));
            ContactoG8 contacto = contactoServiceImplementG8.buscarPorId(idContacto);

            RolOportunidadG8 rolOportunidad = new RolOportunidadG8();
            rolOportunidad.setOportunidad(oportunidad);
            rolOportunidad.setContacto(contacto);


            return rolOportunidad;
        } catch (RuntimeException e) {
            throw new RuntimeException("error al asociar contacto a la oportunidad", e);
        }
    }
}
