package com.G8.TP1_DSI_Grupo8.entityG8;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RolOportunidad")
public class RolOportunidadG8 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRolOportunidad;

    @ManyToOne
    @JoinColumn(name = "idContacto", nullable = false)
    private ContactoG8 contacto;

    @ManyToOne
    @JoinColumn(name = "idOportunidad", nullable = false)
    private OportunidadG8 oportunidad;

    private Date fecha;

    private String otrosDetalles;


    public RolOportunidadG8(Long idRolOportunidad, ContactoG8 contacto, OportunidadG8 oportunidad, Date fecha, String otrosDetalles) {
        this.idRolOportunidad = idRolOportunidad;
        this.contacto = contacto;
        this.oportunidad = oportunidad;
        this.fecha = fecha;
        this.otrosDetalles = otrosDetalles;
    }

    public RolOportunidadG8(){


    }

    public Long getIdRolOportunidad() {
        return idRolOportunidad;
    }

    public void setIdRolOportunidad(Long idRolOportunidad) {
        this.idRolOportunidad = idRolOportunidad;
    }

    public ContactoG8 getContacto() {
        return contacto;
    }

    public void setContacto(ContactoG8 contacto) {
        this.contacto = contacto;
    }

    public OportunidadG8 getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(OportunidadG8 oportunidad) {
        this.oportunidad = oportunidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOtrosDetalles() {
        return otrosDetalles;
    }

    public void setOtrosDetalles(String otrosDetalles) {
        this.otrosDetalles = otrosDetalles;
    }
}
