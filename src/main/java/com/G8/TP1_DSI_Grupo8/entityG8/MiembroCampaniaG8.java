package com.G8.TP1_DSI_Grupo8.entityG8;

import jakarta.persistence.*;

@Entity
@Table(name = "MiembroCampania")
public class MiembroCampaniaG8 {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMiembroCampania;

    @ManyToOne
    @JoinColumn(name = "campania_id", nullable = true)
    private CampaniaG8 campania;

    @ManyToOne
    @JoinColumn(name = "idClientePotencial", nullable = true)
    private ClientePotencialG8 clientePotencial;

    @ManyToOne
    @JoinColumn(name = "idContacto", nullable = false)
    private ContactoG8 contacto;

    public MiembroCampaniaG8(Long idMiembroCampania, CampaniaG8 campania, ClientePotencialG8 clientePotencial, ContactoG8 contacto) {
        this.idMiembroCampania = idMiembroCampania;
        this.campania = campania;
        this.clientePotencial = clientePotencial;
        this.contacto = contacto;
    }

    public MiembroCampaniaG8(){


    }


    public Long getIdMiembroCampania() {
        return idMiembroCampania;
    }

    public void setIdMiembroCampania(Long idMiembroCampania) {
        this.idMiembroCampania = idMiembroCampania;
    }

    public CampaniaG8 getCampania() {
        return campania;
    }

    public void setCampania(CampaniaG8 campania) {
        this.campania = campania;
    }

    public ClientePotencialG8 getClientePotencial() {
        return clientePotencial;
    }

    public void setClientePotencial(ClientePotencialG8 clientePotencial) {
        this.clientePotencial = clientePotencial;
    }

    public ContactoG8 getContacto() {
        return contacto;
    }

    public void setContacto(ContactoG8 contacto) {
        this.contacto = contacto;
    }
}
