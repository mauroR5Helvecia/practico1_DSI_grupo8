package com.G8.TP1_DSI_Grupo8.DTOG8;

public class CrearCuentaDTOG8 {

    private String nombreCuenta;
    private String descripcionCuenta;
    private String telefonoCuenta;
    private String direccionFacturacion;
    private Long idCliente;

    public CrearCuentaDTOG8(){

    }

    public CrearCuentaDTOG8(String nombreCuenta, String descripcionCuenta, String telefonoCuenta, String direccionFacturacion, Long idCliente) {
        this.nombreCuenta = nombreCuenta;
        this.descripcionCuenta = descripcionCuenta;
        this.telefonoCuenta = telefonoCuenta;
        this.direccionFacturacion = direccionFacturacion;
        this.idCliente = idCliente;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getDescripcionCuenta() {
        return descripcionCuenta;
    }

    public void setDescripcionCuenta(String descripcionCuenta) {
        this.descripcionCuenta = descripcionCuenta;
    }

    public String getTelefonoCuenta() {
        return telefonoCuenta;
    }

    public void setTelefonoCuenta(String telefonoCuenta) {
        this.telefonoCuenta = telefonoCuenta;
    }

    public String getDireccionFacturacion() {
        return direccionFacturacion;
    }

    public void setDireccionFacturacion(String direccionFacturacion) {
        this.direccionFacturacion = direccionFacturacion;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
