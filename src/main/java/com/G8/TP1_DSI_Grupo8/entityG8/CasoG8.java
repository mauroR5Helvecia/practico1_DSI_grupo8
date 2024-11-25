package com.G8.TP1_DSI_Grupo8.entityG8;

import jakarta.persistence.*;


@Entity
@Table(name = "Caso")
public class CasoG8 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCaso;

    @ManyToOne
    @JoinColumn(name = "idContacto", nullable = false)
    private ContactoG8 contacto;

    public CasoG8(){


    }

    public CasoG8(Long idCaso, ContactoG8 contacto) {
        this.idCaso = idCaso;
        this.contacto = contacto;
    }

    public Long getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Long idCaso) {
        this.idCaso = idCaso;
    }

    public ContactoG8 getContacto() {
        return contacto;
    }

    public void setContacto(ContactoG8 contacto) {
        this.contacto = contacto;
    }


}
