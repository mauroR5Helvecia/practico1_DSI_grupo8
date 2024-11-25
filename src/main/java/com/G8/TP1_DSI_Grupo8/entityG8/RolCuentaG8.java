package com.G8.TP1_DSI_Grupo8.entityG8;

import jakarta.persistence.*;

@Entity
@Table(name = "RolCuenta")
public class RolCuentaG8 {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRolCuenta;

    @ManyToOne
    @JoinColumn(name = "idContacto", nullable = false)
    private ContactoG8 contacto;

    @ManyToOne
    @JoinColumn(name = "idCuenta", nullable = false)
    private CuentaG8 cuenta;

    public RolCuentaG8(Long idRolCuenta, ContactoG8 contacto, CuentaG8 cuenta) {
        this.idRolCuenta = idRolCuenta;
        this.contacto = contacto;
        this.cuenta = cuenta;
    }

    public RolCuentaG8(){


    }

    public Long getIdRolCuenta() {
        return idRolCuenta;
    }

    public void setIdRolCuenta(Long idRolCuenta) {
        this.idRolCuenta = idRolCuenta;
    }

    public ContactoG8 getContacto() {
        return contacto;
    }

    public void setContacto(ContactoG8 contacto) {
        this.contacto = contacto;
    }

    public CuentaG8 getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaG8 cuenta) {
        this.cuenta = cuenta;
    }
}
