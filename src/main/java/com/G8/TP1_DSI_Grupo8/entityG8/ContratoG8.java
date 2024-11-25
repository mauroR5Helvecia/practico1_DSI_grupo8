package com.G8.TP1_DSI_Grupo8.entityG8;

import jakarta.persistence.*;

@Entity
@Table(name = "Contrato")
public class ContratoG8 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrato;

    private String estadoContrato;
    private String aprobacionContrato;

    @OneToOne
    @JoinColumn(name = "idCuenta", nullable = false)
    private CuentaG8 cuenta;


    public ContratoG8(Long idContrato, String estadoContrato, String aprobacionContrato, CuentaG8 cuenta) {
        this.idContrato = idContrato;
        this.estadoContrato = estadoContrato;
        this.aprobacionContrato = aprobacionContrato;
        this.cuenta = cuenta;
    }

    public ContratoG8(){


    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public String getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(String estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

    public String getAprobacionContrato() {
        return aprobacionContrato;
    }

    public void setAprobacionContrato(String aprobacionContrato) {
        this.aprobacionContrato = aprobacionContrato;
    }

    public CuentaG8 getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaG8 cuenta) {
        this.cuenta = cuenta;
    }
}
