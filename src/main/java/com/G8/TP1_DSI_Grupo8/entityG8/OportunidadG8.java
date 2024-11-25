package com.G8.TP1_DSI_Grupo8.entityG8;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Oportunidad")
public class OportunidadG8 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOportunidad;

    private String decisionOportunidad;
    private String detallesOportunidad;
    private String etapaOportunidad;

    @ManyToOne
    @JoinColumn(name = "idCuenta", nullable = false)
    private CuentaG8 cuenta;

    @OneToMany(mappedBy = "oportunidad", cascade = CascadeType.ALL)
    private List<RolOportunidadG8> rolesOportunidad;

    public OportunidadG8(Long idOportunidad, String decisionOportunidad, String detallesOportunidad, String etapaOportunidad) {
        this.idOportunidad = idOportunidad;
        this.decisionOportunidad = decisionOportunidad;
        this.detallesOportunidad = detallesOportunidad;
        this.etapaOportunidad = etapaOportunidad;
    }

    public OportunidadG8(){

    }

    public Long getIdOportunidad() {
        return idOportunidad;
    }

    public void setIdOportunidad(Long idOportunidad) {
        this.idOportunidad = idOportunidad;
    }

    public String getDecisionOportunidad() {
        return decisionOportunidad;
    }

    public void setDecisionOportunidad(String decisionOportunidad) {
        this.decisionOportunidad = decisionOportunidad;
    }

    public String getDetallesOportunidad() {
        return detallesOportunidad;
    }

    public void setDetallesOportunidad(String detallesOportunidad) {
        this.detallesOportunidad = detallesOportunidad;
    }

    public String getEtapaOportunidad() {
        return etapaOportunidad;
    }

    public void setEtapaOportunidad(String etapaOportunidad) {
        this.etapaOportunidad = etapaOportunidad;
    }

    public CuentaG8 getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaG8 cuenta) {
        this.cuenta = cuenta;
    }

    public List<RolOportunidadG8> getRolesOportunidad() {
        return rolesOportunidad;
    }

    public void setRolesOportunidad(List<RolOportunidadG8> rolesOportunidad) {
        this.rolesOportunidad = rolesOportunidad;
    }
}
