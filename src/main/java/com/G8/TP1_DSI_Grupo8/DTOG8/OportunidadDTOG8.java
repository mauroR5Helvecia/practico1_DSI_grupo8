package com.G8.TP1_DSI_Grupo8.DTOG8;

public class OportunidadDTOG8 {

    private String decisionOportunidad;
    private String detallesOportunidad;
    private String etapaOportunidad;
    private Long idCuenta;

    public OportunidadDTOG8(String decisionOportunidad, String detallesOportunidad, String etapaOportunidad, Long idCuenta) {
        this.decisionOportunidad = decisionOportunidad;
        this.detallesOportunidad = detallesOportunidad;
        this.etapaOportunidad = etapaOportunidad;
        this.idCuenta = idCuenta;
    }

    public OportunidadDTOG8(){

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

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }
}
